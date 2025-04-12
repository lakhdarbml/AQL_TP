package org.example.BranchCoverageTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.QuadraticEquation;

public class QuadraticEquationCorrectTest {

    @Test
    void testBranchPositiveDelta() {
        double[] result = QuadraticEquation.solve(1, -2, -3); // delta = 16
        assertArrayEquals(new double[]{3.0, -1.0}, result);
    }

    @Test
    void testBranchDeltaZero() {
        double[] result = QuadraticEquation.solve(1, 2, 1);
        assertArrayEquals(new double[]{-1.0}, result);
    }

    @Test
    void testBranchDeltaNegative() {
        assertNull(QuadraticEquation.solve(1, 0, 1));
    }

    @Test
    void testBranchAZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }
}
