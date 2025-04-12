package org.example.ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.QuadraticEquation;

public class QuadraticEquationCorrectTest {

    @Test
    void testConditionDeltaPositive() {
        double[] result = QuadraticEquation.solve(1, -5, 6);
        assertArrayEquals(new double[]{3.0, 2.0}, result);
    }

    @Test
    void testConditionDeltaZero() {
        double[] result = QuadraticEquation.solve(4, 4, 1);
        assertArrayEquals(new double[]{-0.5}, result);
    }

    @Test
    void testConditionDeltaNegative() {
        assertNull(QuadraticEquation.solve(1, 2, 5));
    }

    @Test
    void testConditionInvalidA() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 0, 5));
    }
}
