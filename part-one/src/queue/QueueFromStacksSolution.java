package queue;

import java.util.Stack;

public class QueueFromStacksSolution {
    // Q  [10, 20, 30]
    // S1 [10, 20, 30]
    // S2 []
    //
    // Q  [10, 20, 30]
    // S1 []
    // S2 [30, 20, 10]
    //
    // Q  [20, 30]
    // S1 []
    // S2 [30, 20]
    //
    // Q  [20, 30, 50]
    // S1 [50]
    // S2 [30, 20]
    //
    // Q  [30, 50]
    // S1 [50]
    // S2 [30]
    //
    // Q  [50]
    // S1 []
    // S2 [50]

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        aToB();
        return stack2.pop();
    }

    public int peek() {
        aToB();
        return stack2.peek();
    }

    private void aToB() {
        if (isEmpty()) throw new IllegalStateException();
        if (stack2.empty()) {
            while (!stack1.empty()) stack2.push(stack1.pop());
        }
    }

    public boolean isEmpty() {
        return (stack1.empty() && stack2.empty());
    }

}
