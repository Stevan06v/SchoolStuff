package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    Circle k1;
    Circle k2;

    //vor jedem einzelnem test
    @BeforeEach
    void setUp() {}

    //Vor allen tests
    @BeforeAll
    static void init(){}

    @AfterEach
    void tearDown() {
    }

    @Test
    void flaeche() {
        k1 = new Circle(10, 0, 0);
        k2 = new Circle(10, 10, 10);
        assertEquals(314.1592653589793, k1.flaeche());
        Circle k3 = new Circle(90, 0, 0);
        assertEquals(false, k3.equals(k2));
        assertEquals(true, k1.equals(k2));
        assertFalse(k1.equals(null));
    }


}