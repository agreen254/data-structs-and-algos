import hashTable.CustomHashTable;
import hashTable.CustomEntry;
import hashTable.FirstRepeatCharHashMap;
import queue.ArrayQueueShift;
import stackSoln.StringReverser;
import queue.QueueFromStacks;
import queue.PriorityQueueArray;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
//import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack);
//        var top = stack.pop();
//        System.out.println(top);
//        System.out.println(stack);
//        var peek = stack.peek();
//        System.out.println(peek);

        String str = "abcdefghijklmnop";  // reverse this string
        // anytime you have something where you need to go back or undo
        // stacks are very good
//        var stack = new StackLinkedList();
//        for (char ch : str.toCharArray()) stack.push(ch);
//        stack.reverse();

        var reverser = new StringReverser();
        String reversed = reverser.reverse(str);
        System.out.println(reversed);

        // balanced expression
        String balanceTestString = "(([a] + [b]))<c>";
        var balancer = new stack.BalancedExpression();
        var isBalanced = balancer.isBalanced(balanceTestString);
        System.out.println(isBalanced);

        var exp = new stackSoln.BalancedFull("<>(){}[]");
        System.out.println(exp.isBalanced());

        var expOne = new stackSoln.BalancedRefactorOne("<<({ac})>>");
        System.out.println(expOne.isBalanced());

        var st = new stack.StackArray();
        System.out.println(st.isEmpty());
        st.push(5);
        st.push(6);
        st.push(2);
        st.push(3);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());

        var twoStack = new stack.TwoStack(10);
        twoStack.pushA(5);
        twoStack.pushA(2);
        twoStack.pushA(3);
        twoStack.pushA(1);
        twoStack.pushA(9);
        System.out.println(twoStack.isFullA());
        System.out.println(twoStack.isEmptyB());
        var topA = twoStack.popA();
        System.out.println(topA);
        System.out.println(twoStack.peekA());

        System.out.println("MinStack");
        var minStack = new stack.MinStack(5);
        minStack.push(5);
        minStack.push(2);
        minStack.push(8);
        minStack.push(7);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(-5);
        System.out.println(minStack.getMin());

        System.out.println("Queues");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(8);
        System.out.println(queue);
        var queueReverser = new queue.Reverse();
        queueReverser.reverse(queue);
        System.out.println(queue);

        System.out.println("My Array Queue");
        var q = new ArrayQueueShift(3);
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(2);
        System.out.println(q.peek());
        q.dequeue();
        q.enqueue(10);
        System.out.println(q.isFull());
        q.dequeue();
        System.out.println(q.peek());


        System.out.println("My Array Queue with Pointers");
        var qp = new queue.ArrayQueuePointers(3);
        qp.enqueue(5);
        qp.enqueue(3);
        qp.enqueue(1);
        var out = qp.dequeue();
        System.out.println(out);
        System.out.println(qp.peek());
        qp.enqueue(12);
        qp.dequeue();
        out = qp.dequeue();
        System.out.println(out);
        System.out.println(qp.peek());
        qp.enqueue(6);
        qp.enqueue(8);
        System.out.println(qp.isFull());

        System.out.println("Queue from two stacks");
        var qfs = new QueueFromStacks();
        qfs.enqueue(5);
        qfs.enqueue(3);
        qfs.enqueue(1);
        qfs.dequeue();
        System.out.println(qfs.stackString());
        System.out.println(qfs.queueString());
        System.out.println(qfs.peek());
        qfs.enqueue(6);
        qfs.enqueue(2);
        qfs.enqueue(4);
        System.out.println(qfs.peek());
        qfs.dequeue();
        System.out.println(qfs.peek());
        qfs.dequeue();
        System.out.println(qfs.peek());

        System.out.println("Priority Queue Array");
        var pqa = new PriorityQueueArray(3);
        pqa.insert(6);
        System.out.println(pqa);
        pqa.insert(8);
        System.out.println(pqa);
        pqa.insert(1);
        System.out.println(pqa);
        pqa.remove();
        System.out.println(pqa);
        System.out.println(pqa.peek());
        pqa.remove();
        System.out.println(pqa.peek());
        System.out.println(pqa.isFull());
        pqa.remove();
        System.out.println(pqa.empty());

        System.out.println("Priority Queue Solution");
        var pq = new queue.PriorityQueueArraySolution(5);
        pq.add(5);
        pq.add(3);
        pq.add(6);
        pq.add(1);
        pq.add(4);
        System.out.println(pq);

        System.out.println("Queue Kth Reverser");
        int[] qq = { 10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(qq));

        System.out.println("Queue from linked list");
        var qll = new queue.QueueFromLinkedList();
        System.out.println(qll.empty());
        qll.enqueue(10);
        qll.enqueue(20);
        qll.enqueue(30);
        qll.enqueue(40);
        qll.enqueue(50);
        System.out.println(qll.peek());
        qll.dequeue();
        System.out.println(qll.peek());
        qll.enqueue(12);

        System.out.println("Stack From Queues");
        var sfq = new stack.StackFromQueues();
        sfq.push(10);
        sfq.push(20);
        sfq.push(30);
        sfq.push(40);
        sfq.push(50);
        System.out.println(sfq.size());
        System.out.println(sfq.peek());

        System.out.println("Hash Tables");
        System.out.println("First Repeat Char");
        var frc = new FirstRepeatCharHashMap();
        String phrase = "The quick brown fox jumped over the lazy dog";
        char rep = frc.firstRepeat(phrase);
        System.out.println(rep);

        System.out.println("Custom Hash Table");
        var map = new CustomHashTable();
        var entry1 = new CustomEntry(1, "hello");
        var entry2 = new CustomEntry(2, "hey");
        var entry3 = new CustomEntry(3, "what's up");
        var entry4 = new CustomEntry(4, "greetings");
        map.put(entry1);
        map.put(entry2);
        map.put(entry3);
        map.put(entry4);
        System.out.println(map.get(2));
        map.remove(2);
        map.put(new CustomEntry(2, "Added Back"));
        map.put(new CustomEntry(8, "ahasdh"));
        System.out.println(map.get(2));
        System.out.println(map.get(8));
    }
}
