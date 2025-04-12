package org.example.BranchCoverageTest;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.AnagramCorrect;

public class AnagramCorrectTest {

    @Test
    void testNullFirst() {
        assertThrows(NullPointerException.class, () -> AnagramCorrect.isAnagram(null, "abc"));
    }

    @Test
    void testNullSecond() {
        assertThrows(NullPointerException.class, () -> AnagramCorrect.isAnagram("abc", null));
    }

    @Test
    void testDifferentLength() {
        assertFalse(AnagramCorrect.isAnagram("abcd", "abc"));
    }

    @Test
    void testIsAnagramTrue() {
        assertTrue(AnagramCorrect.isAnagram("chien", "niche"));
    }

    @Test
    void testIsAnagramFalse() {
        assertFalse(AnagramCorrect.isAnagram("lune", "soleil"));
    }
}




