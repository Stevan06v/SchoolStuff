package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testEquals() {
        Square s= new Square(12,10,0,0);
        Square s2= new Square(10,12,0,0);
        assertTrue(s.equals(s2));
    }
}