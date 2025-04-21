class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int curr = 0;
        int min = 0;
        int max = 0;

        for (int diff : differences) {
            curr += diff;

            min = Math.min(min, curr);
            max = Math.max(max, curr);

            if (max - min > upper - lower) {
                return 0;
            }
        }

        return upper - max + min - lower + 1;
    }
}
