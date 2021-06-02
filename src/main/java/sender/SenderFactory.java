package sender;

public abstract class SenderFactory {

    public static final SenderFactoryTrouw TROUW = new SenderFactoryTrouw ();
    public static final SenderFactoryAD AD = new SenderFactoryAD ();

    public abstract ISender createSender ();
}