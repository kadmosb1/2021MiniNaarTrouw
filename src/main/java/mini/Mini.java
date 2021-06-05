package mini;

import org.json.JSONObject;

public abstract class Mini {

    private String text;
    private Advertiser advertiser;

    public Mini (JSONObject json) {
        text = json.getString ("Text");
        advertiser = new Advertiser (json.getString("Name"), json.getString("Address"));
    }

    public String getText() {
        return text;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    /*
     * Als een prijs per letter bekend is kan op basis van de lengte van de tekst de totale prijs voor de Mini
     * worden bepaald. Dit is bedoeld om duplicate code in de subclasses op te ruimen.
     */
    protected double getPrice (double pricePerCharacter) {
        return text.length () * pricePerCharacter;
    }

    public abstract double getPrice ();
}
