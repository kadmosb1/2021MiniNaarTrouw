import org.json.JSONObject;

public class MiniInAD extends Mini {

    public MiniInAD (JSONObject jsonMini) {
        super(jsonMini);
    }

    @Override
    public String getEmail() {
        return "kleintje@ad.nl";
    }

    @Override
    public String getNameOfPaper() {
        return "het AD";
    }

    @Override
    public double getPrice () {
        return getAantalKarakters () * 0.21;
    }
}
