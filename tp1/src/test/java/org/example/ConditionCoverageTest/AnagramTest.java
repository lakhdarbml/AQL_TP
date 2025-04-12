package org.example.ConditionCoverageTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Anagram;

public class AnagramTest {

    @Test
    void testConditionsTrue() {
        assertTrue(Anagram.isAnagram("Le Visage", "Gave Lise")); // vrai, tous les tests passent
    }

    @Test
    void testConditionsFalse() {
        assertFalse(Anagram.isAnagram("aaaa", "aaab")); // boucle valide mais compte final invalide
    }

    @Test
    void testConditionLengthFail() {
        assertFalse(Anagram.isAnagram("abc", "abcd")); // longueur différente
    }

    @Test
    void testNullBothConditions() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }
}


