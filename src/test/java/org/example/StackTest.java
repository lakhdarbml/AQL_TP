package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack; // Déclaration commune à tous les tests

    @BeforeEach
    void setUp() {
        stack = new Stack(); // Initialisation avant chaque test
    }

    @Test
    void testPushAndPop() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPeek() {
        stack.push(42);

        assertEquals(42, stack.peek());
        assertEquals(1, stack.size()); // L'élément reste dans la pile
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(5);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    void testExpandArray() {
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }

        assertEquals(15, stack.size());

        for (int i = 14; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }

        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopOnEmptyStackThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void testPeekOnEmptyStackThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, stack::peek);
        assertEquals("Stack is empty", exception.getMessage());
    }
}
