package stack;

import java.util.LinkedList;

public class StackLinkedList {
    private final LinkedList<Character> content = new LinkedList<>();

    public void push(Character content) {
        this.content.push(content);
    }

    public Character pop() {
        Character last = content.getLast();
        content.removeLast();
        return last;
    }

    public Character peek() {
        return content.getLast();
    }

    public boolean isEmpty() {
        return content.isEmpty();
    }

    public void reverse() {
        while (!content.isEmpty()) {
            Character last = content.pop();
            System.out.println(last);
        }
    }
}
