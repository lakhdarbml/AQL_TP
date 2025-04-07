package org.example.ConditionCoverageTest;

import org.example.Palindrome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PalindromeConditionCoverageTest {

    @Test
    void testBothConditionsTrue() {
        assertTrue(Palindrome.isPalindrome("level")); // i < j = true, chars = same
    }

    @Test
    void testCharMismatchConditionFalse() {
        assertFalse(Palindrome.isPalindrome("levil")); // i < j = true, chars !=
    }

    @Test
    void testEdgeCaseSingleChar() {
        assertTrue(Palindrome.isPalindrome("a")); // i == j donc i < j = false
    }

    @Test
    void testNull() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }
}
