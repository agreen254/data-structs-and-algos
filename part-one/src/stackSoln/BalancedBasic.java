package stackSoln;

import java.util.Stack;

public class BalancedBasic {
    private String input;

    public BalancedBasic(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(') stack.push(ch);
            if (ch == ')') {
                if (stack.empty()) return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
