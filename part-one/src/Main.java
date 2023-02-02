import stack.StackLinkedList;
import stackSoln.StringReverser;
import java.util.HashMap;
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
    }
}
