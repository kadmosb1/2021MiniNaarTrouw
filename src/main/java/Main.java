public class Main {

    public static void main(String[] args) {
        new MarktplaatsReceiver ().publishMini ("{ 'Name' : 'Karel J. van der Lelij', " +
                                                "  'Address' : 'Den Haag', " +
                                                "  'Text' : 'Deze tekst moet worden geplaatst in Trouw' }");
    }

}
