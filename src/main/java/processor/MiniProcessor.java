package processor;

import org.json.JSONArray;
import org.json.JSONObject;

import receiver.MarktplaatsReceiver;
import sender.ISender;
import mini.Mini;

import java.util.Observable;
import java.util.Observer;

public abstract class MiniProcessor implements Observer {

    public MiniProcessor (MarktplaatsReceiver receiver) {
        receiver.addObserver (this);
    }

    protected abstract String getName ();

    private boolean mustBePlacedInThisTitle (JSONObject json) {

        String nameOfTitle = getName ();
        JSONArray titles = json.getJSONArray ("Titles");

        for (int i = 0; i < titles.length (); i++) {

            if (titles.getString (i).equals (nameOfTitle)) {
                return true;
            }
        }

        return false;
    }

    protected abstract Mini getMini (JSONObject json);
    protected abstract ISender getSender ();

    public void update (Observable o, Object arg) {

        JSONObject json = new JSONObject ((String) arg);

        if (mustBePlacedInThisTitle (json)) {

            Mini mini = getMini (json);
            ISender sender = getSender ();
            sender.send (mini);
        }
    }
}