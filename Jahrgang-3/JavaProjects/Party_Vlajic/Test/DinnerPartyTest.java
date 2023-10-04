import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DinnerPartyTest {

    @Test
    void calcPrice() {

        DinnerParty dn = new DinnerParty(23, 20, Party.STARS.THREE );
        DinnerParty dn2 = new DinnerParty(23, 20, Party.STARS.ONE );
        DinnerParty dn3 = new DinnerParty(23, 20, Party.STARS.FIVE );
        assertEquals(423, dn.calcPrice());
        assertEquals(173, dn2.calcPrice());
        assertEquals(623, dn3.calcPrice());
    }


    @Test
   void testConstructor(){
        DinnerParty dn = new DinnerParty(23, 20, Party.STARS.THREE );
        assertEquals(23, dn.getZuschlag());
        assertEquals(20, dn.getAnzVisitors());
        assertEquals(Party.STARS.THREE, dn.star);
   }

}