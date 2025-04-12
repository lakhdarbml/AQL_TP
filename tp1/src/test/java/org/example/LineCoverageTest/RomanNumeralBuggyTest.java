package org.example.LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.RomanNumeralBuggy;

public class RomanNumeralBuggyTest {

    @Test
    void testBasicConversion() {
        assertEquals("X", RomanNumeralBuggy.toRoman(10));
    }

    @Test
    void testComplexConversion() {
        assertEquals("MCMXCIV", RomanNumeralBuggy.toRoman(1994));
    }

    @Test
    void testLowerBoundException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralBuggy.toRoman(0));
    }

    @Test
    void testUpperBoundException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralBuggy.toRoman(4000));
    }
}
