package hashTable;

import java.util.Arrays;

public class LinProbe {

    private class Entry {
        public final int key;
        public final String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Entry[] items;

    public LinProbe(int tableSize) {
        items = new Entry[tableSize];
    }

    public void put(int key, String value) {
        int hsh = hash(key);
        while (items[hsh] != null) {
            hsh += 1;
        }
        items[hsh] = new Entry(key, value);
    }

    public String get(int key) {
        var index = items[hash(key)].key;
        while (items[index].key != key) {
            index += 1;
        }
        return items[index].value;
    }

    public void remove(int key) {
        var index = items[hash(key)].key;
        while (items[index].key != key) {
            index += 1;
        }
        items[index] = null;
    }

    public int hash(int key) {
        return key % items.length;
    }
}
