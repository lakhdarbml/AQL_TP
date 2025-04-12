package org.example.ConditionCoverageTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.QuadraticEquationBuggy;

public class QuadraticEquationBuggyTest {

    @Test
    void testNegativeDeltaShouldReturnNull() {
        assertNull(QuadraticEquationBuggy.solve(1, 0, 2)); // ❌ retourne [0.0] au lieu de null
    }

    @Test
    void testDeltaZeroShouldReturnSingleRoot() {
        double[] result = QuadraticEquationBuggy.solve(1, 2, 1); // delta = 0
        assertArrayEquals(new double[]{-1.0}, result); // ❌ retourne null
    }

    @Test
    void testDeltaPositiveShouldReturnTwoRoots() {
        double[] result = QuadraticEquationBuggy.solve(1, -5, 6); // delta = 1
        assertArrayEquals(new double[]{3.0, 2.0}, result); // ❌ retourne une seule racine
    }
}
