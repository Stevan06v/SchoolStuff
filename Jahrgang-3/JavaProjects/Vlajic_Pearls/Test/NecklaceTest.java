import Main.Necklace;
import Main.Pearl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NecklaceTest {
    @Test
    public void Count_NewEmptyBand_ShouldReturnZero() {
        Necklace necklace = new Necklace();
        assertEquals(0, necklace.getCount());
    }

    @Test
    public void Count_AddOne_ShouldReturn1() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        assertEquals(1, necklace.getCount());
    }

    @Test
    public void Count_InsertMany_ShouldReturnCorrectNumber() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));
        assertEquals(7, necklace.getCount());
    }

    @Test
    public void Count_InsertNull_ShouldReturnCorrectNumber() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        necklace.addPearl(null);
        assertEquals(7, necklace.getCount());
    }

    @Test
    public void Count_InsertInvalidPearl_ShouldReturnCorrectNumber() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Black", 2.3));

        assertEquals(0, necklace.getCount());

        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 1.7));
        necklace.addPearl(new Pearl("White", 2.3));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        assertEquals(7, necklace.getCount());
    }

    @Test
    public void GetPearlAtPosition_FirstPos_ShouldReturnPearlAtFirstPos() {
        Necklace necklace = new Necklace();
        Pearl pearl = new Pearl("Red", 1.5);
        necklace.addPearl(pearl);

        Pearl pearlRetrieved = necklace.getPearlAtPosition(0);
        assertEquals(pearl, pearlRetrieved);
    }

    @Test
    public void GetNumberOfColoredPearls_InsertOneOfSameColor_ShouldReturn1() {
        Necklace necklace = new Necklace();
        Pearl pearl = new Pearl("Red", 1.5);
        necklace.addPearl(pearl);
        int count = necklace.getCountOfColoredPearls("Red");
        assertEquals(1, count);
    }

    @Test
    public void GetNumberOfColoredPearls_InsertDifferentColor_ShouldReturn0() {
        Necklace necklace = new Necklace();
        Pearl pearl = new Pearl("Red", 1.5);
        necklace.addPearl(pearl);
        int count = necklace.getCountOfColoredPearls("Blue");
        assertEquals(0, count);
    }

    @Test
    public void GetNumberOfColoredPearls_InsertInvalidColor_ShouldReturn0() {
        Necklace necklace = new Necklace();

        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 1.7));
        necklace.addPearl(new Pearl("White", 2.3));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Yellow", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Black", 7));

        assertEquals(0, necklace.getCountOfColoredPearls("White"));
        assertEquals(0, necklace.getCountOfColoredPearls("Yellow"));
        assertEquals(0, necklace.getCountOfColoredPearls("Black"));
    }

    @Test
    public void GetNumberOfColoredPearls_InsertManyOfColorRed_ShouldReturnCorrectNumber() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));
        int count = necklace.getCountOfColoredPearls("Red");
        assertEquals(3, count);
    }

    @Test
    public void GetNumberOfColoredPearls_InsertManyOfColorBlue_ShouldReturnCorrectNumber() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));
        int count = necklace.getCountOfColoredPearls("Blue");
        assertEquals(3, count);
    }

    @Test
    public void GetNumberOfColoredPearls_InsertOneOfColorGreen_ShouldReturnCorrectNumber() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));
        int count = necklace.getCountOfColoredPearls("Green");
        assertEquals(1, count);
    }

    @Test
    public void GetNumberOfColoredPearls_ColorIsNull_ShouldReturn0() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        int count = necklace.getCountOfColoredPearls(null);
        assertEquals(0, count);
    }

    @Test
    public void GetPearlAtPosition_InsertMany_ShouldReturnCorrectPearlAtPos0() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        Pearl pearl = new Pearl("Red", 7);
        necklace.addPearl(pearl);
        Pearl getPearl = necklace.getPearlAtPosition(0);
        assertEquals(pearl, getPearl);
    }

    @Test
    public void GetPearlAtPosition_InsertMany_ShouldReturnCorrectPearlAtPos4() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        Pearl pearl = new Pearl("Blue", 3);
        necklace.addPearl(pearl);
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        Pearl pearlRetrieved = necklace.getPearlAtPosition(4);
        assertEquals(pearl, pearlRetrieved);
    }

    @Test
    public void GetPearlAtPosition_InsertMany_ShouldReturnCorrectPearlAtPos6() {
        Necklace necklace = new Necklace();
        Pearl pearl = new Pearl("Red", 1.5);
        necklace.addPearl(pearl);
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        Pearl pearlRetrieved = necklace.getPearlAtPosition(6);
        assertEquals(pearl, pearlRetrieved);
    }

    @Test
    public void GetPearlAtPosition_OutOfIndex_ShouldReturnNull() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        Pearl pearlRetrieved = necklace.getPearlAtPosition(7);
        assertEquals(null, pearlRetrieved);
    }

    @Test
    public void GetPearlAtPosition_NegativeIndex_ShouldReturnNull() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        Pearl pearlRetrieved = necklace.getPearlAtPosition(-1);
        assertEquals(null, pearlRetrieved);
    }

    @Test
    public void RemovePearl_RemoveFirst_ShouldReturnPearlWith7Weight() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        Pearl pearl = necklace.removePearl();
        assertEquals(7, pearl.getWeight(), 0.001);
    }

    @Test
    public void RemovePearl_RemoveFromEmptyList_ShouldReturnNull() {
        Necklace necklace = new Necklace();

        Pearl pearl = necklace.removePearl();
        assertEquals(null, pearl);
    }

    @Test
    public void GetTotalWeight_FromEmptyList_ShouldReturn0() {
        Necklace necklace = new Necklace();

        double totalWeight = necklace.getTotalWeight();
        assertEquals(0, totalWeight);
    }

    @Test
    public void GetTotalWeight_FromFilledList_ShouldReturnCorrectWeight() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        double totalWeight = necklace.getTotalWeight();
        assertEquals(28.6, totalWeight, 0.01);
    }

    @Test
    public void RemoveAll_FromFilledList_ShouldReturnCorrectWeightAndCount() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));
        necklace.addPearl(new Pearl("Blue", 2));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 4.0));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 6));
        necklace.addPearl(new Pearl("Red", 7));

        assertEquals(28.6, necklace.getTotalWeight(), 0.01);
        assertEquals(7, necklace.getCount());

        necklace.removeAllPearls();

        assertEquals(0.0, necklace.getTotalWeight(), 0.01);
        assertEquals(0, necklace.getCount());

        necklace.addPearl(new Pearl("Blue", 2.3));
        necklace.addPearl(new Pearl("Red", 1.6));
        necklace.addPearl(new Pearl("Blue", 8.3));

        assertEquals(12.2, necklace.getTotalWeight(), 0.01);
        assertEquals(3, necklace.getCount());

        necklace.removeAllPearls();

        assertEquals(0.0, necklace.getTotalWeight(), 0.01);
        assertEquals(0, necklace.getCount());
    }

    @Test
    public void ToString_FromEmptyList_ShouldReturnCorrectRepresentation() {
        Necklace necklace = new Necklace();
        assertEquals("", necklace.toString());
    }

    @Test
    public void ToString_FromFilledList_ShouldReturnCorrectRepresentation() {
        Necklace necklace = new Necklace();
        necklace.addPearl(new Pearl("Red", 1.5));

        assertEquals("(r)", necklace.toString());

        necklace.addPearl(new Pearl("Blue", 2.6));
        necklace.addPearl(new Pearl("Blue", 3));
        necklace.addPearl(new Pearl("Red", 1.7));
        necklace.addPearl(new Pearl("Green", 5.1));
        necklace.addPearl(new Pearl("Blue", 2.4));
        necklace.addPearl(new Pearl("Green", 1.3));
        necklace.addPearl(new Pearl("Red", 5));

        assertEquals("(R)-(g)-(b)-(G)-(r)-(B)-(B)-(r)", necklace.toString());

        necklace.removePearl();

        assertEquals("(g)-(b)-(G)-(r)-(B)-(B)-(r)", necklace.toString());
    }
}