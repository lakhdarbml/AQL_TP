package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @BeforeEach
    void setUp() {
        // Initialisation si nécessaire (non requis ici car la méthode est statique).
    }

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0), "Factorial de 0 doit être 1");
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, Factorial.factorial(1), "Factorial de 1 doit être 1");
    }

    @Test
    void testFactorialOfPositiveNumbers() {
        assertEquals(2, Factorial.factorial(2), "Factorial de 2 doit être 2");
        assertEquals(6, Factorial.factorial(3), "Factorial de 3 doit être 6");
        assertEquals(24, Factorial.factorial(4), "Factorial de 4 doit être 24");
        assertEquals(120, Factorial.factorial(5), "Factorial de 5 doit être 120");
        assertEquals(3628800, Factorial.factorial(10), "Factorial de 10 doit être 3628800");
    }

    @Test
    void testFactorialThrowsExceptionForNegativeNumbers() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-5);
        }, "Un nombre négatif doit lancer IllegalArgumentException");
        assertEquals("n must be positive", thrown.getMessage());
    }
//fin partie 1
}
