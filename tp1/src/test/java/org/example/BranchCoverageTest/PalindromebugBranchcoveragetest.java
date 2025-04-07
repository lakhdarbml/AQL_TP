package org.example.BranchCoverageTest;

import org.example.Palindrome;
import org.example.Palindromebug;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromebugBranchcoveragetest {

    @Test
    void testPalindromeEvenLength() {
        assertTrue(Palindromebug.isPalindrome("abba")); // parcours normal, retourne true
    }

    @Test
    void testPalindromeOddLength() {
        assertTrue(Palindromebug.isPalindrome("radar")); // parcours normal, retourne true
    }

    @Test
    void testNonPalindrome() {
        assertFalse(Palindromebug.isPalindrome("java")); // déclenche return false dans if
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindromebug.isPalindrome(null));
    }
}
