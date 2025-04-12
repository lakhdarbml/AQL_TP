package org.example.BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.RomanNumeral;

public class RomanNumeralTest {

    @Test
    void testBasicConversion() {
        assertEquals("X", RomanNumeral.toRoman(10));
    }

    @Test
    void testComplexConversion() {
        assertEquals("MCMXCIV", RomanNumeral.toRoman(1994));
    }

    @Test
    void testLowerBoundException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    @Test
    void testUpperBoundException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }
}
