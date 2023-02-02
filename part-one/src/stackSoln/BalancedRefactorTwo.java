package stackSoln;

import java.util.Stack;
import java.util.Arrays;
import java.util.List;

public class BalancedRefactorTwo {
    private String input;
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public BalancedRefactorTwo(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)) stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (bracketsMatch(top, ch)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
