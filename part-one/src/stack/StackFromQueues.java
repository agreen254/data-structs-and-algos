package stack;

import java.util.Queue;
import java.util.ArrayDeque;

public class StackFromQueues {
    private final Queue<Integer> a = new ArrayDeque<>();
    private final Queue<Integer> b = new ArrayDeque<>();
    // Q  [10, 20, 30]      Q  [20, 30]     Q  [30]
    // S1 [10, 20, 30]      S1 [20, 30]     S1 [
    // S2 []                S2 [10]         S2 [

    public void enqueue(int item) {

    }

    public int dequeue() {

    }

    public int peek() {

    }

    public boolean empty() {

    }
}
