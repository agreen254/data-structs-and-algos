package hashTable;

import java.util.LinkedList;

public class CustomHashTable {
    // HashTable
    // put(k, v)
    // get(k) : v
    // remove(k)
    // k: int
    // v: string
    // collisions: chaining

    // hints:
    // we need to store BOTH the key and value in the array to handle duplicates
    // to do this we should internally create a private class Entry
    // Entry wraps the key value pair and should have two fields: key and value
    // we should use a LinkedList[] array
    // [ LL, LL, LL, LL ]
    // initially none of the LLs are initialized (they're all null)
    // we initialize them on demand
    // we should store Entry objects in our linked lists
    int len = 5;
    private final LinkedList<CustomEntry>[] items = new LinkedList[len];

    private int hashFunc(int value) {
        return value % len;
    }

    public void put(CustomEntry entry) {
        // forgot to address situations where you add a same key
        int index = hashFunc(entry.getKey());
        if (emptyIdx(index)) items[index] = new LinkedList<>();
        items[index].add(entry);
    }

    public String get(int key) {
        var index = key % 5;
        if (emptyIdx(index)) throw new IllegalStateException();
        for (CustomEntry e: items[index]) {
            if (e.getKey() == key) {
                return e.getValue();
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hashFunc(key);
        if (emptyIdx(index)) throw new IllegalStateException();
        var item = items[index];
        for (CustomEntry e : item) {
            if (e.getKey() == key) {
                item.remove(e);
                break;
            }
        }
    }

    private boolean emptyIdx(int index) {
        return items[index] == null;
    }
}
