class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] seen = new boolean[101];

        int distinctVals = 0;
        int minVal = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < k) {
                return -1;
            }

            if (!seen[num]) {
                distinctVals++;
                seen[num] = true;
            }
            minVal = Math.min(minVal, num);
        }

        return minVal == k ? distinctVals - 1 : distinctVals;
    }
}
