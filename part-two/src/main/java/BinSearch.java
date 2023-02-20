public class BinSearch {

    public int search(int[] data, int target) {
        int foot = 0;
        int head = data.length - 1;

        while (foot <= head) {
            int middleIdx = (head + foot) / 2;
            int middleVal = data[middleIdx];

            if (middleVal == target) return middleIdx;
            else if (target < middleVal) head = middleIdx - 1;
            else foot = middleIdx + 1;
            // middleVal > target is logically implied
        }
        return -1;
    }

    public int searchRecurse(int[] data, int target, int low, int high) {
        int middleIdx = (low + high) / 2;
        if (data[middleIdx] == target) return middleIdx;
        if (low >= high) return -1;
        if (target < data[middleIdx]) return searchRecurse(data, target, low, high - 1);
        else return searchRecurse(data, target, low + 1, high);
    }
}
