package ch.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Queue$LinkedListTest {

    private Queue$LinkedList queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue$LinkedList();
    }

    @Test
    public void isEmpty_true() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmpty_false() {
        queue.enqueue("val");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void enqueue() {
        String val = "val";
        queue.enqueue(val);
        assertEquals(val, queue.dequeue());
    }

    @Test
    public void dequeue() {
        String first = "1", second = "2";
        queue.enqueue(first);
        queue.enqueue(second);
        assertEquals(first, queue.dequeue());
        assertEquals(second, queue.dequeue());
    }
}