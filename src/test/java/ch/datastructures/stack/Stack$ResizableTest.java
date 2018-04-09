package ch.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Stack$ResizableTest {

    private Stack$Resizable stack;

    @Before
    public void setUp() {
        stack = new Stack$Resizable();
    }

    @Test
    public void isEmpty_true() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmpty_false() {
        stack.push("val");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void push() {
        String first = "1", second = "2";
        stack.push(first);
        stack.push(second);
        assertEquals(second, stack.pop());
        assertEquals(first, stack.pop());
    }

    @Test
    public void pop() {
        String val = "val";
        stack.push(val);
        assertEquals(val, stack.pop());
    }
}