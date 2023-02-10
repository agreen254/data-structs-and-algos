package hashTable;

import java.util.LinkedList;

public class HashSoln {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        var index = hash(key);

        // can't replace with the bucket variable because if we do we won't be able to initialize with array cells
        // here we need to work directly with an array cell
        // the CELL will NOT be initialized to a new LinkedList, but the LOCAL VARIABLE bucket WILL
        if (entries[index] == null) entries[index] = new LinkedList<>();

        // check to see if the key already exists
        // remember, hash maps only have on value per key!
        var bucket = entries[index];
        for (var entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key) return entry.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null) throw new IllegalStateException();  // should learn how to create custom exceptions
        for (var entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private int hash(int key) {
        // good handling if we have a negative key
        key = Math.abs(key);
        return key % entries.length;
    }
}
