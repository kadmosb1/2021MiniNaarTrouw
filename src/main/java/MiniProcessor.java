import org.json.JSONObject;

public class MiniProcessor {

    private Mini mini;

    public MiniProcessor (String jsonString) {

        JSONObject jsonMini = new JSONObject (jsonString);
        String paper = jsonMini.getString ("Paper");

        if (paper.equals ("Trouw")) {
            mini = new MiniInTrouw (jsonMini);
        }
        else if (paper.equals ("AD")) {
            mini = new MiniInAD (jsonMini);
        }
    }

    public void process () {
        Emailer emailer = new Emailer ();
        emailer.prepare (mini);
        emailer.send ();
    }
}
