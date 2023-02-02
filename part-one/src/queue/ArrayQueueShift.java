package queue;

public class ArrayQueueShift {
    private int[] items;
    private int count;

    public ArrayQueueShift(int size) {
        if (size < 1) throw new IllegalArgumentException();
        items = new int[size];
    }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException();
        items[count++] = item;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();
        var first = items[0];
        shiftDown();
        count--;
        return first;
    }

    private void shiftDown() {
        int[] downShifted = new int[items.length];
        for (int i = 1; i < count; i++) downShifted[i - 1] = items[i];
        items = downShifted;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return items[0];
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == items.length);
    }
}
