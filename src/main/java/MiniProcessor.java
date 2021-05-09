import org.json.JSONObject;

public class MiniProcessor {

    private Mini mini;

    public MiniProcessor (String jsonString) {
        mini = new Mini (jsonString);
    }

    public void process () {
        Emailer emailer = new Emailer ();
        emailer.prepare (mini);
        emailer.send ();
    }
}
