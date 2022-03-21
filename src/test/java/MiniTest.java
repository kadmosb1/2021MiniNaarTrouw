import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiniTest {

    @Test
    /*
     * Deze test is gebaseerd op de volgende equivalentieklassen (intensief getest met randwaarden):
     *
     * - 0 < tekstlengte < 25: € 5,00
     * - 25 <= tekstlengte < 100: € 0,20/karakter
     * - tekstlengte >= 100: € 0,18/karakter
     */
    void getPrice() {

        String basics = "'Paper' : 'Trouw', 'Name' : 'Karel J. van der Lelij', 'Address' : 'Den Haag'";
        JSONObject json0 = new JSONObject ("{" + basics + ", 'Text' : '' }");
        JSONObject json1 = new JSONObject ("{" + basics + ", 'Text' : '1' }");
        JSONObject json24 = new JSONObject ("{" + basics + ", 'Text' : 'Test Test Test Test Test' }");
        JSONObject json25 = new JSONObject ("{" + basics + ", 'Text' : 'Test Test Test Test Test' }");
        JSONObject json26 = new JSONObject ("{" + basics + ", 'Text' : 'Test Test Test Test Test T' }");
        JSONObject json99 = new JSONObject ("{" + basics + ", 'Text' : 'Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test' }");
        JSONObject json100 = new JSONObject ("{" + basics + ", 'Text' : 'Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test ' }");
        JSONObject json101 = new JSONObject ("{" + basics + ", 'Text' : 'Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test T' }");

        assertEquals (0.0, new MiniInTrouw (json0).getPrice (), 0.001);
        assertEquals (5.0, new MiniInTrouw (json1).getPrice (), 0.001);
        assertEquals (5.0, new MiniInTrouw (json24).getPrice (), 0.001);
        assertEquals (5.0, new MiniInTrouw (json25).getPrice (), 0.001);
        assertEquals (5.2, new MiniInTrouw (json26).getPrice (), 0.001);
        assertEquals (19.8, new MiniInTrouw (json99).getPrice (), 0.001);
        assertEquals (18.0, new MiniInTrouw (json100).getPrice (), 0.001);
        assertEquals (18.18, new MiniInTrouw (json101).getPrice (), 0.001);
    }
}