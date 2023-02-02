package stack;

import java.util.Arrays;

public class MinStack {
    private final int[] items;
    private final int[] minima;
    private int count;
    private int minimum;

    public MinStack(int size) {
        if (size < 1) throw new IllegalArgumentException();
        items = new int[size];
        minima = new int[size];
    }

    public void push(int item) {
        if (count == items.length) throw new StackOverflowError();
        if (count == 0) minimum = item;

        items[count] = item;
        checkMin(item);
        minima[count] = minimum;
        count++;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        return items[--count];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void checkMin(int against) {
        if (against < minimum) {
            minimum = against;
        }
    }

    public int getMin() {
        return minima[count - 1];
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

    public String minimaToString() {
        var content = Arrays.copyOfRange(minima, 0, count);
        return Arrays.toString(content);
    }
}
