package stack;

public class StackArray {
    // Stack
    // push
    // pop
    // peek
    // isEmpty
    // int[]
    private int[] content;
    private int numItems;


    public void push(int item) {
        if (isEmpty()) {
            content = new int[1];
            content[0] = item;
        } else {
            if (tooBig()) copy();
            content[numItems] = item;
        }
        numItems++;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        numItems--;
        return content[numItems];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return content[numItems - 1];
    }

    public void copy() {
        var copier = new int[numItems * 2];
        for (int i = 0; i < content.length; i++) copier[i] = content[i];
        content = copier;
    }

    public boolean tooBig() {
        return content.length + 1 > numItems;
    }

    public boolean isEmpty() {
        return (content == null);
    }
}
