package hashTable;

import java.util.HashSet;
import java.util.Arrays;

public class CountPairsWithDiff {
    public int countPairsWithDiff(int[] arr, int diff) {
        int num_diffs = 0;
        var set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        var uniques = set.toArray();



        for (int i = 0; i < uniques.length; i++){
            for (int j = 0; j < uniques.length; j++) {
                if (Math.abs((int)uniques[i] - (int)uniques[j]) == diff) {
                    num_diffs += 1;  // double counts
                }
            }
        }

        return num_diffs / 2;
    }
}
