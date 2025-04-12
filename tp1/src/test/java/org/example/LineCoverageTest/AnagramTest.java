package org.example.LineCoverageTest;

import org.example.Anagram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AnagramTest {

    @Test
    void testBasicAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    void testDifferentLengthStrings() {
        assertFalse(Anagram.isAnagram("abc", "abcd"));
    }

    @Test
    void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    void testNullInputs() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
    }
}
