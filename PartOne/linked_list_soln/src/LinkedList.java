import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    // now, because Node is declared INSIDE of our LinkedList class,
    // we have access to the private fields such as value and next
    // internally. Then we don't have to worry about using
    // a getter or a setter for these private properties.

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
//        if (first == null) {
//            first = node;
//            last = node;
//        }
    }

    public void addFirst(int item) {  // got it
        var node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    // create private method to see if the list is empty or not
    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        var current = first;
        return indexOf(item) != -1;  // nice!
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    // O(1)
    // if you were to traverse the whole list each time to get the size,
    // that runtime complexity would be O(n)
    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var idx = 0;
        while (current != null) {
            array[idx++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        // [10 -> 20 -> 30] before reversal
        // [10 <- 20 <- 30] after reversal
        // doesn't return a new list; reverses this list in place
        var three = first;
        first = last;
        last = three;
    }
}
