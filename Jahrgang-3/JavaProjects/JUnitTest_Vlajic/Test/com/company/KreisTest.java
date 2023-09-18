package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KreisTest {


    @Test
    void flaeche() {
        Kreis k1 = new Kreis(10);
        assertEquals(100*Math.PI, k1.flaeche());
    }

    @Test
    void umfang() {
        Kreis k1 = new Kreis(10);
        assertNotNull(k1, "Not Null");
        assertEquals(20*Math.PI, k1.umfang());
    }


}