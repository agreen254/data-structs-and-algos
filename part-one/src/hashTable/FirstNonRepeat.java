package hashTable;

import java.util.Map;
import java.util.HashMap;

public class FirstNonRepeat {
    // oops, I did the first repeating character instead of first non-repeating character
    public char findFirstNonRepeatChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = str.toCharArray();
        for (var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (var ch : chars) {
            if (map.get(ch) == 1) return ch;
        }
        return Character.MIN_VALUE;
    }
}
