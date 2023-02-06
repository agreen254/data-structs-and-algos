package queue;

import linkedListSoln.LinkedList;

public class QueueFromLinkedList {
    private final LinkedList items = new LinkedList();

    public void enqueue(int item) {
        items.addLast(item);
    }

    public int dequeue() {
        var first = items.getFirst();
        items.removeFirst();
        return first;
    }

    public int peek() {
        return items.getFirst();
    }

    public int size() {
        return items.getSize();
    }

    public boolean empty() {
        return (items.getSize() == 0);
    }
}
