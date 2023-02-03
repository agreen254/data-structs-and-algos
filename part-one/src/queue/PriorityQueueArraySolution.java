package queue;

import java.util.Arrays;

public class PriorityQueueArraySolution {
    private int[] items;
    private int count;

    public PriorityQueueArraySolution(int size) {
        items = new int[size];
    }

    public void add(int item) {
        if (isFull()) throw new IllegalStateException();
        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) items[i + 1] = items[i];
            else break;
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
