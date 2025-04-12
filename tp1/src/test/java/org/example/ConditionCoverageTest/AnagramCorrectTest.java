package org.example.ConditionCoverageTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.AnagramCorrect;

public class AnagramCorrectTest {

    @Test
    void testConditionsTrue() {
        assertTrue(AnagramCorrect.isAnagram("Le Visage", "Gave Lise")); // vrai, tous les tests passent
    }

    @Test
    void testConditionsFalse() {
        assertFalse(AnagramCorrect.isAnagram("aaaa", "aaab")); // boucle valide mais compte final invalide
    }

    @Test
    void testConditionLengthFail() {
        assertFalse(AnagramCorrect.isAnagram("abc", "abcd")); // longueur différente
    }

    @Test
    void testNullBothConditions() {
        assertThrows(NullPointerException.class, () -> AnagramCorrect.isAnagram(null, null));
    }
}


