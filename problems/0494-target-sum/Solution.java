class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        if (sum < Math.abs(target)) {
            return 0;
        }

        int n = nums.length;
        int m = sum * 2;

        int[][] dp = new int[n + 1][m + 1];
        dp[0][sum] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j <= m - nums[i]; j++) {
                dp[i + 1][j - nums[i]] += dp[i][j];
                dp[i + 1][j + nums[i]] += dp[i][j];
            }
        }

        return dp[n][sum + target];
    }
}
