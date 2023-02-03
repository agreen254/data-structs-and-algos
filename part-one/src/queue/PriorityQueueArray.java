package queue;

import java.util.Arrays;

public class PriorityQueueArray {
    // make a priority queue of integers
    // the queue is always sorted such that the lowest integer will be removed first
    private final int[] items;
    private int count;

    public PriorityQueueArray(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException();
        items = new int[capacity + 1];
    }

    public void insert(int item) {
        if (isFull()) throw new IllegalStateException();

        if (count == 0) {
            items[count++] = item;
            return;
        }
        sort(item);
        count++;
    }

    private void sort(int item) {
        for (int i = count - 1; i >= 0; i--) {
            if (item > items[i]) items[i + 1] = item;
            else {
                items[i + 1] = items[i];
                items[i] = item;
            }
        }

    }

    public int remove() {  // I remove the first item but the solution removes the last item?
        if (empty()) throw new IllegalStateException();

        var top = items[0];
        for (int i = 0; i < count - 1; i++) {
            System.out.println("i = " + i);
            items[i] = items[i + 1];
        }
        count--;
        return top;
    }

    public int peek() {
        if (empty()) throw new IllegalStateException();
        return items[0];
    }

    public boolean empty() {
        return count == 0;
    }

    public boolean isFull() {
        return (count == items.length - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
