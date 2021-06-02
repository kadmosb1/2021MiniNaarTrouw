package processor;

import mini.MiniAD;
import org.json.JSONObject;

import receiver.MarktplaatsReceiver;
import mini.Mini;
import sender.ISender;
import sender.EmailerAD;
import sender.SenderFactory;

public class MiniProcessorAD extends MiniProcessor {

    public MiniProcessorAD (MarktplaatsReceiver receiver) {
        super (receiver);
    }

    @Override
    protected String getName () {
        return "AD";
    }

    @Override
    protected Mini getMini (JSONObject json) {
        return new MiniAD(json);
    }

    @Override
    protected ISender getSender () {
        return SenderFactory.AD.createSender ();
    }
}
