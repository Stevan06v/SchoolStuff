package bakery;


import org.junit.jupiter.api.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DrinkTest {
  Drink d;
  
  public DrinkTest() {
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
      d = new Drink("Kaffee", 0.2, 1.3);
    }
    catch (BakeryException ex) {
      Logger.getLogger(DrinkTest.class.getName()).log(Level.SEVERE, null, ex);
    }
  }


  @AfterEach
  public void tearDown() {
  }


  @Test
  public void testSetName() {
    try {
      d.setName("xy");
      fail("Exception not thrown!");
    }
    catch (BakeryException ex) {
    }
    catch (Exception e) {
      fail("Invalid exception thrown!");
    }
  }


  @Test
  public void testSetCupSize1() {
    try {
      d.setCupSize(0);
      fail("Exception not thrown!");
    }
    catch (BakeryException ex) {
    }
    catch (Exception e) {
      fail("Invalid exception thrown!");
    }
  }


  @Test
  public void testSetCupSize2() {
    try {
      d.setCupSize(1.1);
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
      d.setPrice(-0.1);
      fail("Exception not thrown!");
    }
    catch (BakeryException ex) {
    }
    catch (Exception e) {
      fail("Invalid exception thrown!");
    }
  }

  @Test
  public void testGetName() {
    assertEquals("Kaffee, 0.2 l", d.calcName());
  }


  @Test
  public void testGetPrice() {
    assertEquals(1.3, d.calcPrice(), 0.001);
  }
}
