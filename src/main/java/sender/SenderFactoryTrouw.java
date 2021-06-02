package sender;

public class SenderFactoryTrouw extends SenderFactory {

    @Override
    public ISender createSender() {
        return new EmailerTrouw ();
    }
}
