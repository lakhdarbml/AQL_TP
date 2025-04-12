package org.example.ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.BinarySearchCorrect;

public class BinarySearchCorrectTest {

    @Test
    void testConditionMidEqualsElementTrue() {
        int[] array = {1, 2, 3};
        assertEquals(1, BinarySearchCorrect.binarySearch(array, 2)); // mid == element → true
    }

    @Test
    void testConditionMidLessThanElementTrue() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(3, BinarySearchCorrect.binarySearch(array, 4)); // mid < element → true
    }

    @Test
    void testConditionMidGreaterThanElementTrue() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(1, BinarySearchCorrect.binarySearch(array, 2)); // mid > element → true
    }

    @Test
    void testConditionAllFalseReturnsMinusOne() {
        int[] array = {1, 2, 3, 4};
        assertEquals(-1, BinarySearchCorrect.binarySearch(array, 6)); // pas trouvé
    }

    @Test
    void testEdgeCaseOneElementMatch() {
        int[] array = {5};
        assertEquals(0, BinarySearchCorrect.binarySearch(array, 5));
    }

    @Test
    void testEdgeCaseOneElementNoMatch() {
        int[] array = {7};
        assertEquals(-1, BinarySearchCorrect.binarySearch(array, 3));
    }
}
