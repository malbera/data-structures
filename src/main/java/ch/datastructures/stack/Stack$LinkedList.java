package ch.datastructures.stack;

public class Stack$LinkedList {

    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String result = first.item;
        first = first.next;
        return result;
    }

    class Node {
        String item;
        Node next;
    }

}
