import org.json.JSONObject;

public class Mini {

    private String text;
    private Advertiser advertiser;

    public Mini (String jsonString) {

        JSONObject jsonObject = new JSONObject (jsonString);
        text = jsonObject.getString ("Text");
        advertiser = new Advertiser (jsonObject.getString("Name"), jsonObject.getString("Address"));
    }

    public String getText() {
        return text;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public double getPrice () {

        int aantalKarakters = text.length ();

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
