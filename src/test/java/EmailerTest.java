import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailerTest {

    @Test
    void prepare () {
        Emailer emailer = new Emailer ();

        String name = "Karel J. van der Lelij";
        String address = "Den Haag";
        String text = "Deze tekst moet worden geplaatst in Trouw";
        String json = String.format ("{ 'Name' : '%s', 'Address' : '%s', 'Text' : '%s' }", name, address, text);

        emailer.prepare (new Mini (json));

        String expectedBody = String.format ("Tekst: %s%nPrijs: € %.2f%n%nNaam adverteerder: %s%nAdres: %s%n",
                                             text, 8.20, name, address);
        String expectedMail = String.format ("Volgende mail wordt aan %s verzonden met onderwerp '%s':%n%n%s",
                                             Emailer.EMAIL_TROUW, Emailer.SUBJECT, expectedBody);

        assertTrue (emailer.getMessage ().equals (expectedMail));
    }
}