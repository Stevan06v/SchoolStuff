import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayPartyTest {


    @Test
    void calcPrice() {
        BirthdayParty bd = new BirthdayParty(32, 32, 40, 12);
        assertEquals(278, bd.calcPrice());
    }

    @Test
    void testConstructor() {
        BirthdayParty bd = new BirthdayParty(32, 32, 40, 12);
        assertEquals(32, bd.getSnacks());
        assertEquals(32, bd.getGetranke());
        assertEquals(40, bd.getZuschlag());
        assertEquals(12, bd.getAnzVisitors());
    }
}