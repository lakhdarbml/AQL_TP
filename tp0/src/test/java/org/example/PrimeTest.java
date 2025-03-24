package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void testNegativeNumberIsNotPrime() {
        assertFalse(Prime.isPrime(-5), "-5 ne doit pas être premier");
        assertFalse(Prime.isPrime(-1), "-1 ne doit pas être premier");
    }

    @Test
    void testZeroAndOneAreNotPrime() {
        assertFalse(Prime.isPrime(0), "0 ne doit pas être premier");
        assertFalse(Prime.isPrime(1), "1 ne doit pas être premier");
    }

    @Test
    void testSmallPrimeNumbers() {
        assertTrue(Prime.isPrime(2), "2 est un nombre premier");
        assertTrue(Prime.isPrime(3), "3 est un nombre premier");
        assertTrue(Prime.isPrime(5), "5 est un nombre premier");
        assertTrue(Prime.isPrime(7), "7 est un nombre premier");
    }

    @Test
    void testNonPrimeNumbers() {
        assertFalse(Prime.isPrime(4), "4 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(6), "6 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(9), "9 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(15), "15 n'est pas un nombre premier");
    }

    @Test
    void testLargePrimeNumber() {
        assertTrue(Prime.isPrime(97), "97 est un nombre premier");
    }

    @Test
    void testLargeNonPrimeNumber() {
        assertFalse(Prime.isPrime(100), "100 n'est pas un nombre premier");
    }
}
