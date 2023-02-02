package queue;

import java.lang.Math;

public class ArrayQueuePointers {
    private final int[] items;
    private int front;
    private int back;
    private int counter;

    public ArrayQueuePointers(int size) {
        if (size < 1) throw new IllegalArgumentException();
        items = new int[size];
    }

    public void enqueue(int item) {
        if (counter == items.length) throw new IllegalStateException();
        items[back] = item;
        incrementBack();
    }

    public int dequeue() {
        var first = items[front];
        incrementFront();
        return first;
    }

    public int peek() {
        return items[front];
    }

    private void incrementFront() {
        if (front == items.length - 1) front = 0;
        else front++;
        counter--;
    }

    private void incrementBack() {
        if (back == items.length - 1) back = 0;
        else back++;
        counter++;
    }

    public boolean isEmpty() {
        return (back == front);
    }

    public boolean isFull() {
        return (counter == items.length);
    }
}
