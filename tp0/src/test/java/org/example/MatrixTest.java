package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    void testMatrixInitialization() {
        Matrix matrix = new Matrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, matrix.get(i, j), "Matrix should initialize with zeros");
            }
        }
    }

    @Test
    void testSetAndGet() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, 5);
        assertEquals(5, matrix.get(0, 0), "Set or Get method is incorrect");
    }

    @Test
    void testAddValidMatrices() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m2.set(0, 0, 3);
        m2.set(0, 1, 4);

        m1.add(m2);

        assertEquals(4, m1.get(0, 0), "Addition result is incorrect");
        assertEquals(6, m1.get(0, 1), "Addition result is incorrect");
    }

    @Test
    void testAddWithNullMatrix() {
        Matrix m1 = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m1.add(null), "Should throw NullPointerException for null matrix");
    }

    @Test
    void testAddWithDifferentSize() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.add(m2), "Should throw IllegalArgumentException for different size");
    }

    @Test
    void testMultiplyValidMatrices() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);

        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m2.set(0, 0, 3);
        m2.set(1, 0, 4);

        m1.multiply(m2);

        assertEquals(11, m1.get(0, 0), "Multiplication result is incorrect");
    }

    @Test
    void testMultiplyWithNullMatrix() {
        Matrix m1 = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m1.multiply(null), "Should throw NullPointerException for null matrix");
    }

    @Test
    void testMultiplyWithDifferentSize() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.multiply(m2), "Should throw IllegalArgumentException for different size");
    }

    @Test
    void testTranspose() {
        Matrix m1 = new Matrix(2);
        m1.set(0, 1, 5);
        m1.set(1, 0, 3);

        m1.transpose();

        assertEquals(5, m1.get(1, 0), "Transpose result is incorrect");
        assertEquals(3, m1.get(0, 1), "Transpose result is incorrect");
    }

    @Test
    void testToString() {
        Matrix m1 = new Matrix(2);
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(1, 0, 3);
        m1.set(1, 1, 4);

        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, m1.toString(), "toString output is incorrect");
    }
}
