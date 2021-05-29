package receiver;

import java.util.Observable;

public class MarktplaatsReceiver extends Observable {

    public void publishMini (String mini) {
        setChanged ();
        notifyObservers (mini);
    }
}
