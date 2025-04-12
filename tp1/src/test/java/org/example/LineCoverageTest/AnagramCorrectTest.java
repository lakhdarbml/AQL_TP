package org.example.LineCoverageTest;

import org.example.AnagramCorrect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AnagramCorrectTest {

    @Test
    void testBasicAnagram() {
        assertTrue(AnagramCorrect.isAnagram("chien", "niche"));
    }

    @Test
    void testDifferentLengthStrings() {
        assertFalse(AnagramCorrect.isAnagram("abc", "abcd"));
    }

    @Test
    void testEmptyStrings() {
        assertTrue(AnagramCorrect.isAnagram("", ""));
    }

    @Test
    void testNullInputs() {
        assertThrows(NullPointerException.class, () -> AnagramCorrect.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> AnagramCorrect.isAnagram("test", null));
    }
}
