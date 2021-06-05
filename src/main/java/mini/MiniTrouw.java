package mini;

import org.json.JSONObject;

public class MiniTrouw extends Mini {

    public MiniTrouw (JSONObject json) {
        super (json);
    }

    public double getPrice () {

        int aantalKarakters = getText ().length ();
        double pricePerCharacter;

        // Bij meer dan 100 karakters geldt een prijs per karakter van € 0,18.
        if (aantalKarakters >= 100) {
            pricePerCharacter = 0.18;
        }
        // Tussen de 25 en 100 karakters geldt een prijs per karakter van € 0,20.
        else if (aantalKarakters >= 25) {
            pricePerCharacter = 0.20;
        }
        // Er geldt een basisprijs van € 5,00.
        else if (aantalKarakters > 0) {
            return 5.0;
        }
        // Voor een lege advertentie/Mini betaal je niets (die wordt ook niet geplaatst).
        else {
            return 0.0;
        }

        // Als de prijs per karakter bekend is, wordt deze prijs vermenigvuldigd met het aantal karakters.
        // Om duplicate code te verwijderen is deze methode opgenomen in de superclass Mini.
        return getPrice (pricePerCharacter);
    }
}