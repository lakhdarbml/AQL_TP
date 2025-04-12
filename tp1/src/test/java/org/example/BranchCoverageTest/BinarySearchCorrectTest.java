package org.example.BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.BinarySearchCorrect;

public class BinarySearchCorrectTest {

    @Test
    void testElementFoundLeft() {
        int[] array = {10, 20, 30, 40};
        assertEquals(0, BinarySearchCorrect.binarySearch(array, 10)); // va vers la gauche
    }

    @Test
    void testElementFoundRight() {
        int[] array = {10, 20, 30, 40};
        assertEquals(3, BinarySearchCorrect.binarySearch(array, 40)); // va vers la droite
    }

    @Test
    void testElementInMiddle() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearchCorrect.binarySearch(array, 5)); // match direct
    }

    @Test
    void testElementNotFound() {
        int[] array = {1, 3, 5, 7};
        assertEquals(-1, BinarySearchCorrect.binarySearch(array, 4)); // ni gauche ni droite
    }

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearchCorrect.binarySearch(null, 1));
    }
}
