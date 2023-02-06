package linkedListSoln;

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

    public int getFirst() {
        return first.value;
    }

    public int getSize() {
        return size;
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
        if (size == 0 || size == 1) return;
        else if (size == 2) {
            var three = first;
            first = last;
            last = three;
            first.next = last;
            last.next = null;
        }
        else {
            // working case for three items
//            var three = first;
//            var second = first.next;
//
//            first = last;
//            last = three;
//
//            first.next = second;
//            second.next = last;
//
//            last.next = null;


//            var swapper = first;
//            var second = first.next;
//            var third = second.next;
//            var fourth = third.next;
//            var fifth = fourth.next;
//
//            first = last;
//            last = swapper;
//
//            first.next = fifth;
//            fifth.next = fourth;
//            fourth.next = third;
//            third.next = second;
//
//            second.next = last;
//            last.next = null;

            var nodes = new Node[size];
            var current = first;
            nodes[0] = current;
            for (int i = 1; i < size - 1; i++) {
                nodes[i] = current.next;
                current = current.next;
            }
            nodes[size - 1] = last;

            var swapper = first;
            first = last;
            last = swapper;
            last.next = null;
            var c = first;
            for (int i = 0, j = size - 1; j >= 0; i++, j--) {
                c.next = nodes[j];
                c = nodes[j];
            }
            // SUCCESS!
        }
    }

    public void reverseSoln() {
        // [10 -> 20 -> 30]
        //  p     c     n
        //  next = c.next
        //  c.next = p
        // [10 <- 20    30]
        //        p     c     n
        // [10 <- 20 <- 30]
        //              p     c
        // stop here, when c references nothing
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int kFromEndFirst(int k) {
        // if the item is the final element, return 1
        if (k <= 0 || k > size) throw new IllegalArgumentException();
        if (k == 1) return last.value;
        if (k == size) return first.value;

        int i = 0;
        var current = first;
        while (current.next != null) {
            if (size - i++ == k) return current.value;
            current = current.next;
        }
        return -1;
    }

    public int kFromEndSecond(int k) {
        if (k <= 0 || k > size) throw new IllegalArgumentException();
        if (k == 1) return last.value;
        if (k == size) return first.value;

        // using two pointers is a powerful technique for linked list problems
        var pOne = first;
        var pTwo = first;
        for (int i = 0; i < k - 1; i++) pTwo = pTwo.next;
        while (pTwo.next != null) {
            pTwo = pTwo.next;
            pOne = pOne.next;
        }
        return pOne.value;
    }

    public int kFromEndSoln(int k) {
        // if (k > size) throw new IllegalArgumentException();
        // but sometimes we don't know size of linked list
        // don't worry about error checking if k <= 0
        if (isEmpty()) throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null) throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle() {
        var a = first;
        var b = first;
        while (true) {
            b = b.next;
            if (b == null) {
                System.out.println(a.value);
                break;
            }
            b = b.next;
            if (b == null) {
                System.out.println(a.value);
                System.out.println(a.next.value);
                break;
            }
            a = a.next;
        }
    }

    public void printMiddleSoln() {
        if (isEmpty()) throw new IllegalArgumentException();

        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }
        if (b == last) System.out.println(a.value);
        else System.out.println(a.value + ", " + a.next.value);
    }

    public boolean checkForLoop() {
        var a = first;
        var b = first;
        while (b != null) {
            if (a == b.next || a == b.next.next) return true;
            a = a.next;
            b = b.next.next;
        }
        return false;
    }
}
