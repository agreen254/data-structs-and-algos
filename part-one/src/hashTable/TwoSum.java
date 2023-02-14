package hashTable;

public class TwoSum {
    public int[] twoSum(int[] input, int target) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] + input[j] == target && i != j) return new int[] { i, j };
            }
        }

        return new int[] { -1, -1 };
    }
}
