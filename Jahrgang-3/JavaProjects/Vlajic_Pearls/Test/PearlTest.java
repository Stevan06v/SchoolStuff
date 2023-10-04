import Main.Pearl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PearlTest {
    @Test
    public void Constructor_NewRedPearl_ShouldReturnCorrectColorAndWeight() {
        Pearl pearl = new Pearl("Red", 1.7);
        assertEquals("Red", pearl.getColor());
        assertEquals(1.7, pearl.getWeight());
    }

    @Test
    public void Constructor_NewGreenPearl_ShouldReturnCorrectColorAndWeight() {
        Pearl pearl = new Pearl("Green", 2.3);
        assertEquals("Green", pearl.getColor());
        assertEquals(2.3, pearl.getWeight());
    }

    @Test
    public void Constructor_NewBluePearl_ShouldReturnCorrectColorAndWeight() {
        Pearl pearl = new Pearl("Blue", 0.3);
        assertEquals("Blue", pearl.getColor());
        assertEquals(0.3, pearl.getWeight());
    }

    @Test
    public void Constructor_InvalidColor_ShouldReturnUnknownColor() {
        Pearl pearl = new Pearl("Yellow", -10);
        assertEquals("Unknown", pearl.getColor());
    }

    @Test
    public void Constructor_InvalidColor_ShouldReturnZeroWeight() {
        Pearl pearl = new Pearl("Yellow", 1.3);
        assertEquals(0, pearl.getWeight());
    }

    @Test
    public void Constructor_WrongWeight_ShouldReturnOne() {
        Pearl pearl = new Pearl("Red", -10);
        assertEquals(1, pearl.getWeight());
    }

    @Test
    public void Constructor_NullReference_ShouldReturnUnknownColor() {
        Pearl pearl = new Pearl(null, -10);
        assertEquals("Unknown", pearl.getColor());
    }

    @Test
    public void Constructor_NullReference_ShouldReturnZero() {
        Pearl pearl = new Pearl(null, -10);
        assertEquals(0, pearl.getWeight());
    }

    @Test
    public void ToString_SmallPearls_ShouldReturnCorrectRepresentation() {
        Pearl pearl = new Pearl("Red", 1.7);
        assertEquals("(r)", pearl.toString());

        pearl = new Pearl("Green", 2.49);
        assertEquals("(g)", pearl.toString());

        pearl = new Pearl("Blue", 0.3);
        assertEquals("(b)", pearl.toString());
    }

    @Test
    public void ToString_LargePearls_ShouldReturnCorrectRepresentation() {
        Pearl pearl = new Pearl("Red", 12.34);
        assertEquals("(R)", pearl.toString());

        pearl = new Pearl("Green", 2.5);
        assertEquals("(G)", pearl.toString());

        pearl = new Pearl("Blue", 4);
        assertEquals("(B)", pearl.toString());
    }
}