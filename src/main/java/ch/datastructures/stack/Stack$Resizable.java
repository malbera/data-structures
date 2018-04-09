package ch.datastructures.stack;

public class Stack$Resizable {

    private String [] items;
    private int count = 0;

    public Stack$Resizable() {
        this.items = new String[1];
    }

    public boolean isEmpty() {
        return items.length == 1 && items[0] == null;
    }

    public void push(String item) {
        if (count == items.length) resize(items.length << 2);
        items[count++] = item;
    }

    public String pop() {
        String result = items[--count];
        items[count] = null;
        if (count > 0 && count == items.length << 4) {
            resize(items.length >> 2);
        }
        return result;
    }

    private void resize(int capacity) {
        String [] copy = new String[capacity];
        System.arraycopy(items, 0, copy, 0, capacity > items.length ? items.length : capacity);
        items = copy;
    }

}
