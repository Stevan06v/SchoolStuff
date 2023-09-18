import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PartyManagerTest {

    PartyManager pm;
    DinnerParty dp;
    BirthdayParty bp;

    @Test
    void addParty() {
        pm = new PartyManager();
        bp = new BirthdayParty(20, 10, 20,20);
        assertEquals(true, pm.addParty(bp));
    }

    @Test
    void calculatPrice() {
        pm = new PartyManager();
        bp = new BirthdayParty(20, 10, 20,20);
        pm.addParty(bp);
        assertEquals(170, pm.calculatPrice());
    }


}