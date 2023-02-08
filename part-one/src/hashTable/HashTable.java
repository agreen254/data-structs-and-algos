package hashTable;

import java.util.LinkedList;
import java.util.Arrays;

public class HashTable {
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
    private final LinkedList[] items = new LinkedList[5];

    private static class Entry {
        public int key;
        public String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Entry entry) {

    }

    public int get(int key) {
        return 0;
    }

    public void remove(int key) {

    }
}
