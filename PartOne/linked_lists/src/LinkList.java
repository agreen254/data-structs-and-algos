import java.awt.*;

public class LinkList {
    private Node first;
    private Node last;

    // addFirst check
    // addLast check
    // deleteFirst check
    // deleteLast check
    // contains check
    // indexOf (first index of) check

    public void addFirst(int value) {
        if (first == null) first = new Node(value);
        else {
            Node firstNew = new Node(value);
            firstNew.setNext(first);
            first = firstNew;
        }
    }

    public void print() {
        Node next = first;
        while (next != null) {
            System.out.println(next.getValue());
            next = next.getNext();
        }
    }

    public void deleteFirst() {
        if (first.getNext() == null) {
            first = null;
            return;
        }
        Node next = first.getNext();
        first.setNext(null);
        first = next;
    }

    public void addLast(int value) {
        if (first != null) {
            Node l = new Node(value);
            Node someNode = first;
            while(someNode.getNext() != null) someNode = someNode.getNext();
            someNode.setNext(l);
        } else {
            first = new Node(value);
        }
    }

    public void deleteLast() {
        Node one = first;
        Node two = one.getNext();
        if (two == null) {
            first = null;
            return;
        }
        while(two.getNext() != null) {
            one = one.getNext();
            two = two.getNext();
        }
        one.setNext(null);
    }

    public boolean contains(int value) {
        Node someNode = first;
        while(someNode != null) {
            if (someNode.getValue() == value) return true;
            someNode = someNode.getNext();
        }
        return false;
    }

    public int indexOf(int value) {
        Node someNode = first;
        int counter = 0;
        while(someNode != null) {
            if (someNode.getValue() == value) {
                return counter;
            }
            someNode = someNode.getNext();
            counter++;
        }
        return -1;
    }
}
