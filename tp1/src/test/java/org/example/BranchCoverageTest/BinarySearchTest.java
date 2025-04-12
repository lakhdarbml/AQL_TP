package org.example.BranchCoverageTest;

import org.example.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class BinarySearchTest {

    @Test
    void testElementFoundLeft() {
        int[] array = {10, 20, 30, 40};
        assertEquals(0, BinarySearch.binarySearch(array, 10)); // va vers la gauche
    }

    @Test
    void testElementFoundRight() {
        int[] array = {10, 20, 30, 40};
        assertEquals(3, BinarySearch.binarySearch(array, 40)); // va vers la droite
    }

    @Test
    void testElementInMiddle() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(array, 5)); // match direct
    }

    @Test
    void testElementNotFound() {
        int[] array = {1, 3, 5, 7};
        assertEquals(-1, BinarySearch.binarySearch(array, 4)); // ni gauche ni droite
    }

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }
}
