import org.json.JSONObject;

public class MiniInTrouw extends Mini {

    public MiniInTrouw (JSONObject jsonMini) {
        super (jsonMini);
    }

    @Override
    public String getEmail() {
        return "mini@trouw.nl";
    }

    @Override
    public String getNameOfPaper() {
        return "Trouw";
    }

    @Override
    public double getPrice () {

        int aantalKarakters = getAantalKarakters ();

        if (aantalKarakters >= 100) {
            return aantalKarakters * 0.18;
        }
        else if (aantalKarakters >= 25) {
            return aantalKarakters * 0.20;
        }
        else if (aantalKarakters > 0) {
            return 5.0;
        }
        else {
            return 0.0;
        }
    }
}