class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        long[] sum = new long[n + 1];

        for (int[] query : queries) {
            sum[query[0]]++;
            sum[query[1] + 1]--;
        }

        for (int i = 0; i < n; i++) {
            if (sum[i] < nums[i]) {
                return false;
            }
            sum[i + 1] += sum[i];
        }

        return true;
    }
}
