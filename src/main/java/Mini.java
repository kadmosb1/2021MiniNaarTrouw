import org.json.JSONObject;

public abstract class Mini {

    private String text;
    private Advertiser advertiser;

    public Mini (JSONObject jsonMini) {
        text = jsonMini.getString ("Text");
        advertiser = new Advertiser (jsonMini.getString("Name"), jsonMini.getString("Address"));
    }

    public String getText() {
        return text;
    }

    public int getAantalKarakters () {
        return text.length ();
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public abstract String getEmail ();
    public abstract String getNameOfPaper ();
    public abstract double getPrice();
}