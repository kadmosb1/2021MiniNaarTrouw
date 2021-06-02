package sender;

public class SenderFactoryAD extends SenderFactory {

    @Override
    public ISender createSender() {
        return new EmailerAD ();
    }
}
