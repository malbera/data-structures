package ch.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int count;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public void addFirst(Item item) {
        addValidation(item);
        if (isEmpty()) {
            first = new Node();
            last = first;
        } else {
            Node old = first;
            first = new Node();
            first.next = old;
            old.prev = first;
        }
        first.value = item;
        count++;
    }

    public void addLast(Item item) {
        addValidation(item);
        if (isEmpty()) {
            first = new Node();
            last = first;
        } else {
            Node old = last;
            last = new Node();
            last.prev = old;
            old.next = last;
        }
        last.value = item;
        count++;
    }

    public Item removeFirst() {
        removeValidation();
        if (count > 0) {
            Node old = first;
            if (old.next != null) {
                first = old.next;
                first.prev = null;
            } else {
                first = last = null;
            }
            count--;
            return old.value;
        } else {
            throw new NoSuchElementException();
        }
    }

    public Item removeLast() {
        removeValidation();
        if (count > 0) {
            Node old = last;
            if (old.prev != null) {
                last = last.prev;
                last.next = null;
            } else {
                last = first = null;
            }
            count--;
            return old.value;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            removeValidation();
            return removeFirst();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private void removeValidation() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void addValidation(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    private class Node {

        private Node next, prev;
        private Item value;
    }


}
