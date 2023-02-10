package hashTable;

public class CustomEntry {
    private final int key;
    private final String value;

    public CustomEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "<" + this.key + ", " + this.value + ">";
    }
}
