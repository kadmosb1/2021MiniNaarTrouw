public class MarktplaatsReceiver {

    public void publishMini (String mini) {
        // TODO: Er moet nog een mechanisme worden geïmplementeerd waardoor er tegelijkertijd (asynchroon) meerder MiniProcessor's actief kunnen zijn.
        new MiniProcessor (mini).process ();
    }
}
