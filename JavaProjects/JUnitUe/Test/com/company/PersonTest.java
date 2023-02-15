package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @BeforeEach
    void setUp() {
        System.out.println("before");
    }

    @Test
    void testToString() {
        Person p = new Person("Vlajic", "Stevan", 34);
        assertEquals("Stevan, Vlajic, 34", p.toString());
    }

    @Test
    void testEquals(){
        Person p1 = new Person("Vlajic", "Stevan", 34);
        Person p2 = new Person("Vlajic", "Stevan", 34);
        assertEquals(p1,p2);
    }
    @Test

    void getVn() {

    }

    @Test
    void setVn() {
    }

    @Test
    void getNn() {
    }

    @Test
    void setNn() {
    }
}