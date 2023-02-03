package queue;

import java.util.Stack;

public class QueueFromStacks {
    // use two stacks to create a queue
    private Stack<Integer> a = new Stack<>();
    private Stack<Integer> b = new Stack<>();
    // [10, 20, 30, 40, 50]
    // [50, 40, 30, 20, 10]
    public void enqueue(int item) {
        a.push(item);
    }

    public int dequeue() {
        if (b.isEmpty()){
            while (!a.isEmpty()) b.push(a.pop());
        }
        return b.pop();
    }

    public int peek() {
        if (!b.isEmpty()) return b.peek();
        return a.firstElement();
    }

    public boolean isEmpty() {
        return (a.isEmpty() && b.isEmpty());
    }

    public String stackString() {
        return a.toString();
    }

    public String queueString() {
        return b.toString();
    }
}
