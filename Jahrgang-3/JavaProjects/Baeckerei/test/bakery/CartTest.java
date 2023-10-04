package bakery;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CartTest {
  Cart c;


  public CartTest() {
  }


  @BeforeAll
  public static void setUpClass() throws Exception {
  }


  @AfterAll
  public static void tearDownClass() throws Exception {
  }


  @BeforeEach
  public void setUp() {
    c = new Cart();
  }


  @AfterEach
  public void tearDown() {
  }


  @Test
  public void testGetValue() {
    try {
      c.addContent(new Position(new Drink("Kaffee", 0.2, 1.6), 2));
      assertEquals(3.2, c.getValue(), 0.001);

      c.addContent(new Position(new FoodPacked("Nuts", 0.6), 3));
      assertEquals(5, c.getValue(), 0.001);

      c.addContent(new Position(new FoodOpen("Leberkäse", 1000, 14.50), 200));
      assertEquals(7.9, c.getValue(), 0.001);
    }
    catch (BakeryException ex) {
      fail("Unexpected Exception thrown!");
    }
  }


  @Test
  public void testPrintReceipt() {
  }
}
