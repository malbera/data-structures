package ch.datastructures.queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node node;
    private int count;

    public boolean isEmpty() {
        return node == null;
    }

    public int size() {
        return count;
    }

    public void enqueue(Item item) {
        validateEnqueue(item);
        if (isEmpty()) {
            node = new Node();
        } else {
            Node old = node;
            node = new Node();
            node.prev = old;
            old.next = node;
        }
            node.val = item;
        count++;
    }

    public Item dequeue() {
        Node remove = getRandomNode();
        Node prev = remove.prev, next = remove.next;
        if (prev != null) {
            prev.next = next;
            node = prev;
        }
        if (next != null) {
            next.prev = prev;
            node = next;
        }
        if (prev == null && next == null) {
            node = null;
        }
        count--;
        return remove.val;
    }

    public Item sample() {
        return getRandomNode().val;
    }

    private Node getRandomNode() {
        validateEmptyPop();
        Node result = node;
        for (int i=0; i<StdRandom.uniform(0, size()); i++) {
            result = node.prev;
        }
        return result;
    }

    private void validateEnqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEmptyPop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class Node {
        private Node next, prev;
        private Item val;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            return dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
