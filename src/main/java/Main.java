public class Main {

    public static void main(String[] args) {
        new MarktplaatsReceiver ().publishMini ("{ 'Paper' : 'Trouw', " +
                                                "  'Name' : 'Adverteerder 1', " +
                                                "  'Address' : 'Den Haag', " +
                                                "  'Text' : 'Deze tekst moet worden geplaatst in Trouw' }");

        System.out.println ("============================\n");
        new MarktplaatsReceiver ().publishMini ("{ 'Paper' : 'AD', " +
                "  'Name' : 'Adverteerder 2', " +
                "  'Address' : 'Rijswijk', " +
                "  'Text' : 'Deze tekst moet worden geplaatst in het AD' }");
    }

}
