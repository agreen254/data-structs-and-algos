package stack;

import java.util.Stack;
import java.util.HashMap;

public class BalancedExpression {
    private Character[] openBrackets = { '(', '{', '[', '<' };
    private Character[] closedBrackets = { ')', '}', ']', '>' };
    private final HashMap<Character, Character> closedOpened = new HashMap<>();

    public BalancedExpression() {
        for (int i = 0; i < openBrackets.length; i++) {
            closedOpened.put(closedBrackets[i], openBrackets[i]);
        }
    }

    private boolean isOpener(Character input) {
        for (Character ch : openBrackets) if (input == ch) return true;
        return false;
    }

    private boolean isCloser(Character input) {
        for (Character ch : closedBrackets) if (input == ch) return true;
        return false;
    }

    private Character getOpenMatch(Character closedBracket) {
        return closedOpened.get(closedBracket);
    }

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = false;
        int activeOpen = 0;
        for (Character ch : input.toCharArray()) {
            if (isOpener(ch)) {
                stack.push(ch);
                activeOpen++;
            }
            if (isCloser(ch)) {
                stack.push(ch);
                var opener = getOpenMatch(ch);
                while (!stack.empty()) {
                    var last = stack.pop();
                    if (opener == last) {
                        isBalanced = true;
                        activeOpen--;
                        break;
                    }
                    isBalanced = false;
                }
            }
        }
        if (activeOpen != 0) isBalanced = false;
        return isBalanced;
    }
}
