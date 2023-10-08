package at.htlleonding.demo.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void testConstructor() {
        Teacher teacher = new Teacher(8, "MALE", 9.8, "Stevan", "Vlajic");
        Teacher teacher2 = new Teacher(8, "MALE", 9.8, "Stevan", "Vlajic");

        assertEquals(1, teacher.getId());
    }
}