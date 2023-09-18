/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalverwaltung;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author steva
 */
public class MitarbeiterTest {
    
    public MitarbeiterTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getLastNr method, of class Mitarbeiter.
     */
    @Test
    public void testGetLastNr() {
        System.out.println("getLastNr");
        int expResult = 0;
        int result = Mitarbeiter.getLastNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastNr method, of class Mitarbeiter.
     */
    @Test
    public void testSetLastNr() {
        System.out.println("setLastNr");
        int aLastNr = 0;
        Mitarbeiter.setLastNr(aLastNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVn method, of class Mitarbeiter.
     */
    @Test
    public void testGetVn() {
        System.out.println("getVn");
        Mitarbeiter instance = new Mitarbeiter();
        String expResult = "";
        String result = instance.getVn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVn method, of class Mitarbeiter.
     */
    @Test
    public void testSetVn() {
        System.out.println("setVn");
        String vn = "";
        Mitarbeiter instance = new Mitarbeiter();
        instance.setVn(vn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNn method, of class Mitarbeiter.
     */
    @Test
    public void testGetNn() {
        System.out.println("getNn");
        Mitarbeiter instance = new Mitarbeiter();
        String expResult = "";
        String result = instance.getNn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNn method, of class Mitarbeiter.
     */
    @Test
    public void testSetNn() {
        System.out.println("setNn");
        String nn = "";
        Mitarbeiter instance = new Mitarbeiter();
        instance.setNn(nn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLfdNr method, of class Mitarbeiter.
     */
    @Test
    public void testGetLfdNr() {
        System.out.println("getLfdNr");
        Mitarbeiter instance = new Mitarbeiter();
        int expResult = 0;
        int result = instance.getLfdNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLfdNr method, of class Mitarbeiter.
     */
    @Test
    public void testSetLfdNr() {
        System.out.println("setLfdNr");
        int lfdNr = 0;
        Mitarbeiter instance = new Mitarbeiter();
        instance.setLfdNr(lfdNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
