package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PalindromeLinecoveragetest {

    @Test
    void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak")); // ligne return true
    }

    @Test
    void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello")); // ligne return false
    }

    @Test
    void testWithSpacesAndCases() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void testNullString() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }
}