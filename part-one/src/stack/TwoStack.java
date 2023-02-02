package stack;

public class TwoStack {
    private final int[] items;
    private int countA = 0;
    private int countB = 1;

    public TwoStack(int size) {
        if (size % 2 != 0 || size < 2) throw new IllegalArgumentException();
        items = new int[size];
    }

    public void pushA(int item) {
        if (countA == items.length) throw new StackOverflowError();
        countA += 2;
        items[countA - 1] = item;
    }

    public void pushB(int item) {
        if (countB == items.length - 1) throw new StackOverflowError();
        countB += 2;
        items[countB - 1] = item;
    }

    public int popA() {
        if (isEmptyA()) throw new IllegalStateException();
        countA -= 2;
        return items[countA + 1];
    }

    public int popB() {
        if (isEmptyB()) throw new IllegalStateException();
        countB -= 2;
        return items[countB + 1];
    }

    public int peekA() {
        if (isEmptyA()) throw new IllegalStateException();
        return items[countA - 1];
    }

    public int peekB() {
        if (isEmptyB()) throw new IllegalStateException();
        return items[countB - 1];
    }

    public boolean isFullA() {
        return (countA == items.length);
    }

    public boolean isFullB() {
        return (countB == items.length - 1);
    }

    public boolean isEmptyA() {
        return countA == 0;
    }

    public boolean isEmptyB() {
        return countB == 1;
    }
}
