package hashTable;

import java.util.HashMap;

public class MostFrequent {
    public int mostFrequent(int[] arr) {
        var map = makeOccurrenceMap(arr);
        return getMapMax(map);
    }

    private HashMap<Integer, Integer> makeOccurrenceMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }

        return map;
    }

    private int getMapMax (HashMap<Integer, Integer> map) {
        int maxVal = 0;
        int maxKey = 0;

        for (var item : map.entrySet()) {
            if (item.getValue() > maxVal) {
                maxVal = item.getValue();
                maxKey = item.getKey();
            }
        }

        return maxKey;
    }
}
