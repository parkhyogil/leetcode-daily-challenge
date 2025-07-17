class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[n][k];
        int result = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int r = (nums[i] + nums[j]) % k;

                dp[i][r] = Math.max(dp[i][r], dp[j][r] + 1);
                result = Math.max(result, dp[i][r]);
            }
        }

        return result + 1;
    }
}
