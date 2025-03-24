package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullName() {
        Person p =new Person("lakhdar","bouchemal",15);
         String result = p.getFullName();
        assertEquals("lakhdar bouchemal", result);
    }

    @Test
    void isAdult() {
        Person p =new Person("lakhdar","bouchemal",15);
        boolean result = p.isAdult();
        assertEquals(false, result);
    }
    @Test
    void testGetFullName() {
        Person person = new Person("John", "Doe", 25);
        assertEquals("John Doe", person.getFullName());
    }

    @Test
    void testIsAdultWhenAdult() {
        Person adult = new Person("Alice", "Smith", 20);
        assertTrue(adult.isAdult());
    }

    @Test
    void testIsAdultWhenMinor() {
        Person minor = new Person("Bob", "Brown", 17);
        assertFalse(minor.isAdult());
    }

    @Test
    void testBoundaryAge() {
        Person exactly18 = new Person("Charlie", "Young", 18);
        assertTrue(exactly18.isAdult());
    }


}