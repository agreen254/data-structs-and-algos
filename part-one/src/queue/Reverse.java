package queue;

import java.util.Queue;
import java.util.Stack;

public class Reverse {  // exact same implementation as solution!
    public void reverse(Queue<Integer> queue) {
        var reversed = new Stack<Integer>();
        while (!queue.isEmpty()) {
            reversed.push(queue.remove());
        }
        while (!reversed.isEmpty()) {
            queue.add(reversed.pop());
        }
    }
}
