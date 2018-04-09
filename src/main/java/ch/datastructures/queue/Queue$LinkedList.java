package ch.datastructures.queue;

public class Queue$LinkedList {

    private Node first, last;

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node old = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            old.next = last;
        }
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    private class Node {
        String item;
        Node next;
    }
}
