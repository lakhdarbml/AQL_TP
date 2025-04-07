package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeBranchcoveragetest {

    @Test
    void testPalindromeEvenLength() {
        assertTrue(Palindrome.isPalindrome("abba")); // parcours normal, retourne true
    }

    @Test
    void testPalindromeOddLength() {
        assertTrue(Palindrome.isPalindrome("radar")); // parcours normal, retourne true
    }

    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("java")); // déclenche return false dans if
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }
}
