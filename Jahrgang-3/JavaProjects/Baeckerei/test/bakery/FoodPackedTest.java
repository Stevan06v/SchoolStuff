package bakery;


import org.junit.jupiter.api.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FoodPackedTest {
  FoodPacked f;


  public FoodPackedTest() {
  }


  @BeforeAll
  public static void setUpClass() throws Exception {
  }


  @AfterAll
  public static void tearDownClass() throws Exception {
  }


  @BeforeEach
  public void setUp() {
    try {
      f = new FoodPacked("Manner", 0.6);
    }
    catch (BakeryException ex) {
      Logger.getLogger(FoodPackedTest.class.getName()).log(Level.SEVERE, null,
        ex);
    }
  }


  @AfterEach
  public void tearDown() {
  }


  @Test
  public void testSetName() {
    try {
      f.setName("x");
      fail("Exception not thrown!");
    }
    catch (BakeryException ex) {
    }
    catch (Exception e) {
      fail("Invalid exception thrown!");
    }
  }


  @Test
  public void testSetPrice() {
    try {
      f.setPrice(-5);
      fail("Exception not thrown!");
    }
    catch (BakeryException ex) {
    }
    catch (Exception e) {
      fail("Invalid exception thrown!");
    }
  }


  @Test
  public void testGetPrice() {
    assertEquals(0.6, f.calcPrice(), 0.001);
  }
}
