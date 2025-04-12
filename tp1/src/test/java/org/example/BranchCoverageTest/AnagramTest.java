package org.example.BranchCoverageTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Anagram;

public class AnagramTest {

    @Test
    void testNullFirst() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    @Test
    void testNullSecond() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    @Test
    void testDifferentLength() {
        assertFalse(Anagram.isAnagram("abcd", "abc"));
    }

    @Test
    void testIsAnagramTrue() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    void testIsAnagramFalse() {
        assertFalse(Anagram.isAnagram("lune", "soleil"));
    }
}


