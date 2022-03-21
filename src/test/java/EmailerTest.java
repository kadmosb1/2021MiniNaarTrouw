import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailerTest {

    @Test
    void prepare () {

        Emailer emailer = new Emailer ();

        String paper = "Trouw";
        String name = "Karel J. van der Lelij";
        String address = "Den Haag";
        String text = "Deze tekst moet worden geplaatst in Trouw";
        JSONObject json = new JSONObject (String.format ("{ 'Paper' : '%s', 'Name' : '%s', 'Address' : '%s', 'Text' : '%s' }", paper, name, address, text));

        Mini mini = new MiniInTrouw (json);
        emailer.prepare (mini);

        String expectedBody = String.format ("Tekst: %s%nPrijs: € %.2f%n%nNaam adverteerder: %s%nAdres: %s%n",
                                             text, 8.20, name, address);
        String expectedMail = String.format ("Volgende mail wordt aan %s verzonden met onderwerp '%s':%n%n%s",
                                             mini.getEmail (), Emailer.SUBJECT + mini.getNameOfPaper (), expectedBody);

        assertEquals (emailer.getMessage(), expectedMail);
    }
}