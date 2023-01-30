import java.util.Arrays;
import java.util.ArrayList;

public class Array {
    // methods needed:
    // insert(item)
    // print()
    // removeAt(idx)
    // indexOf(item)
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {
        // if array is full, resize it
        if (items.length == count) {
            // create a new array (twice the size)
            int[] newItems = new int[count * 2];

            // copy all existing items over
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }

            // set "items" to this new array
            items = newItems;
        }

        // add the new item at the end of the array
        items[count] = item;
        count++;

        // can also do items[count++] = item
        // increment happens after variable is set
    }

    public void removeAt(int idx) {
        if (idx < 0 || idx > count) {
            // throw new Exception("invalid index."); didn't know proper exception
        }

        int[] newItems = new int[count - 1];
        int afterRemoval = count - idx;

        for (int i = 0; i < count - 1; i++) {
            if (i > afterRemoval) newItems[i] = items[i + 1];
            else newItems[i] = items[i];
        }

        items = newItems;
        count--;
    }

    public void removeAtMosh(int index) {
        // validate the index
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        // shift the items to the left to fill the hole
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];  // still have the last index
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (item == items[i]) return i;
        }
        return -1;
    }

    public int max() {
        // O(n)
        int max = items[0];
        for (int i = 0; i < count; i++) {
            if (items[i] > max) max = items[i];
        }
        return max;
    }

    public int[] intersect(int[] other) {
        // can make a class object of itself inside itself??? Java??
        Array common = new Array(1);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < other.length; j++) {
                if (items[i] == other[j]) {
                    common.insert(items[i]);
                    break;
                }
            }
        }
        int[] result = new int[common.count];
        for (int i = 0; i < common.count; i++) {
            result[i] = common.items[i];
        }
        return result;
    }

    public Array reverse() {
        Array reversed = new Array(1);
        for (int i = count - 1; i >= 0; i--) {
            reversed.insert(items[i]);
        }
        return reversed;
    }

    public void insertAt(int idx, int value) {
        Array copy = new Array(1);
        if (idx < 0 || idx > count) {
            throw new IllegalArgumentException();
        }

        int before = 0;
        while (before < idx) {
            copy.insert(items[before]);
            before++;
        }
        copy.insert(value);
        for (int i = idx; i < count; i++) {
            copy.insert(items[i]);
        }

        items = copy.items;
        count++;
    }
}
