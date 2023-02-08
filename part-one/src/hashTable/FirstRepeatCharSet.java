package hashTable;

import java.util.HashSet;

public class FirstRepeatCharSet {
    private final HashSet<Character> set = new HashSet<>();

    public char getFirstRepeat(String str) {
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
