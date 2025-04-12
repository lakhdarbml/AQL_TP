package org.example.LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.QuadraticEquation;

public class QuadraticEquationCorrectTest {

    @Test
    void testTwoSolutions() {
        double[] result = QuadraticEquation.solve(1, -3, 2); // delta = 1
        assertArrayEquals(new double[]{2.0, 1.0}, result);
    }

    @Test
    void testOneSolution() {
        double[] result = QuadraticEquation.solve(1, 2, 1); // delta = 0
        assertArrayEquals(new double[]{-1.0}, result);
    }

    @Test
    void testNoSolution() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // delta < 0
    }

    @Test
    void testInvalidA() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }
}
