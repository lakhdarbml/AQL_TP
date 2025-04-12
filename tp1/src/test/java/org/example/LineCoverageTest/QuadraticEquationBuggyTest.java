package org.example.LineCoverageTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.QuadraticEquationBuggy;

public class QuadraticEquationBuggyTest {

    @Test
    void testDeltaNegativeReturnsNull() {
        assertNull(QuadraticEquationBuggy.solve(1, 0, 1)); // delta < 0 => devrait être null ❌
    }

    @Test
    void testDeltaZeroReturnsSingleRoot() {
        double[] result = QuadraticEquationBuggy.solve(1, 2, 1); // delta == 0 => devrait renvoyer [-1.0]
        assertArrayEquals(new double[]{-1.0}, result); // ❌ échoue car retourne null
    }

    @Test
    void testDeltaPositiveReturnsTwoRoots() {
        double[] result = QuadraticEquationBuggy.solve(1, -3, 2); // delta > 0 => 2 racines attendues
        assertArrayEquals(new double[]{2.0, 1.0}, result); // ❌ échoue car retourne une seule racine
    }

    @Test
    void testInvalidCoefficientA() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquationBuggy.solve(0, 1, 1)); // ✅ passe
    }
}
