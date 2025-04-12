package org.example.LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.BinarySearchCorrect;

public class BinarySearchCorrectTest {

    @Test
    void testFoundElement() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearchCorrect.binarySearch(array, 5));
    }

    @Test
    void testElementNotFound() {
        int[] array = {2, 4, 6, 8};
        assertEquals(-1, BinarySearchCorrect.binarySearch(array, 5));
    }

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearchCorrect.binarySearch(null, 3));
    }
    @Test
    void testElementNotFoundLastOne() {
        int[] array = {2, 3, 4, 5};
        assertEquals(3, BinarySearchCorrect.binarySearch(array, 5));
    }
}
