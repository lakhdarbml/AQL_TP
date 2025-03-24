package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void fibonacciUn() {
        Fibonacci f = new Fibonacci();
        assertEquals(1,f.fibonacci(1));
    }
    @Test
    void fibonacciZero() {
        Fibonacci f = new Fibonacci();
        assertEquals(0,f.fibonacci(0));
    }
    @Test
    void fibonacciInferioreZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
        assertEquals("n must be positive", exception.getMessage());
    }



    @Test
    void testFibonacciOfPositiveNumber() {

        assertEquals(8, Fibonacci.fibonacci(6), "F(6) doit retourner 8");
    }

    @Test
    void testFibonacciLargeNumber() {
        assertEquals(55, Fibonacci.fibonacci(10), "F(10) doit retourner 55");
    }


}