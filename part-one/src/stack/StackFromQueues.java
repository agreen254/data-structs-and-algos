package stack;

import java.util.Queue;
import java.util.ArrayDeque;

public class StackFromQueues {
    private final ArrayDeque<Integer> a = new ArrayDeque<>();
    private final ArrayDeque<Integer> b = new ArrayDeque<>();
    private int size;

    public void push(int item) {
        a.add(item);
        size++;
    }

    public int pop() {
        if (empty()) throw new IllegalStateException();
        aToB();
        size--;
        return b.remove();
    }

    public int peek() {
        if (empty()) throw new IllegalStateException();
        aToB();
        return b.peek();
    }

    private void aToB() {
        while (!a.isEmpty()) {
            b.add(a.removeLast());
        }
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }
}
