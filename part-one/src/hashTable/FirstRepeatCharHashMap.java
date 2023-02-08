package hashTable;

import java.util.HashMap;

public class FirstRepeatCharHashMap {
    private final HashMap<Character, Integer> map = new HashMap<>();

    public FirstRepeatCharHashMap() {
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        map.put('d', 0);
        map.put('e', 0);
        map.put('f', 0);
        map.put('g', 0);
        map.put('h', 0);
        map.put('i', 0);
        map.put('j', 0);
        map.put('k', 0);
        map.put('l', 0);
        map.put('m', 0);
        map.put('n', 0);
        map.put('o', 0);
        map.put('p', 0);
        map.put('q', 0);
        map.put('r', 0);
        map.put('s', 0);
        map.put('t', 0);
        map.put('u', 0);
        map.put('v', 0);
        map.put('w', 0);
        map.put('x', 0);
        map.put('y', 0);
        map.put('z', 0);
    }

    public char firstRepeat(String input) {
        input = input.toLowerCase();
        for (char letter : input.toCharArray()) {
            if (letter != ' ') {
                map.put(letter, map.get(letter) + 1);
                if (map.get(letter) == 2) return letter;
            }
        }
        return 'X';

    }
}
