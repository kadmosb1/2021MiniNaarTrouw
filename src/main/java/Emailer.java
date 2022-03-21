import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class Emailer {

    protected static final String EMAIL_MINIMARKT = "minimarkt@dpgmedia.nl";
    protected static final String SUBJECT = "Graag plaatsing van onderstaande mini in ";

    private MimeMessage message;

    public void prepare (Mini mini) {

        // Om dit te laten werken, moet natuurlijk een mailserver zijn geïnstalleerd op 'host'.
        String host = "localhost";

        // Initialiseer de server.
        Properties properties = System.getProperties ();
        properties.setProperty ("mail.smtp.host", host);

        Session session = Session.getDefaultInstance (properties);

        // Bereid de mail voor.
        try {
            message = new MimeMessage (session);
            message.setFrom (new InternetAddress(EMAIL_MINIMARKT));
            message.addRecipient (Message.RecipientType.TO, new InternetAddress (mini.getEmail()));
            message.setSubject (SUBJECT + mini.getNameOfPaper());

            // Bereid de tekst voor de mail voor.
            Advertiser advertiser = mini.getAdvertiser ();
            message.setText (String.format ("Tekst: %s%nPrijs: € %.2f%n%nNaam adverteerder: %s%nAdres: %s%n",
                                            mini.getText(), mini.getPrice(), advertiser.getName(), advertiser.getAddress()));
        }
        catch (MessagingException mex) {
            mex.printStackTrace ();
        }
    }

    protected String getMessage () {

        try {
            return String.format ("Volgende mail wordt aan %s verzonden met onderwerp '%s':%n%n%s",
                                  message.getAllRecipients () [0], message.getSubject (), message.getContent ());
        }
        catch (IOException | MessagingException e) {
            e.printStackTrace ();
            return "";
        }
    }

    public void send () {

        // Zolang de mailserver niet is geïnstalleerd, wordt de mail alleen op het scherm getoond.
        System.out.println (getMessage ());

        /*
         * // Het bericht wordt verzonden.
         * try {
         *     TODO: Installeer mailserver op localhost.
         *     Transport.send (message);
         * }
         * catch (MessagingException mex) {
         *     mex.printStackTrace();
         *     return String.format ("Het is niet gelukt om de mail te verzenden naar %s", EMAIL_TROUW);
         * }
         */
    }
}