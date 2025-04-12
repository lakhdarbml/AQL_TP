package org.example.BranchCoverageTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.QuadraticEquationBuggy;

public class QuadraticEquationBuggyTest {

    @Test
    void testNegativeDeltaBranch() {
        assertNull(QuadraticEquationBuggy.solve(2, 1, 1)); // delta = -7, devrait renvoyer null ❌
    }

    @Test
    void testDeltaZeroBranch() {
        double[] result = QuadraticEquationBuggy.solve(1, 2, 1); // delta = 0
        assertArrayEquals(new double[]{-1.0}, result); // ❌ retourne null
    }

    @Test
    void testPositiveDeltaBranch() {
        double[] result = QuadraticEquationBuggy.solve(1, -5, 6); // delta = 1
        assertArrayEquals(new double[]{3.0, 2.0}, result); // ❌ retourne une seule racine
    }
}
