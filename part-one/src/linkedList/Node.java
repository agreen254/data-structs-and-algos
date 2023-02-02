package linkedList;

public class Node {
    private int value;
    private Node next;

    public Node(int val) {
        value = val;
        next = null;
    }

    public void setNext(Node nextNode) {
        next = nextNode;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }
}
