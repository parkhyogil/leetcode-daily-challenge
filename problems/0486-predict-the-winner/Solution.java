class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int c = 0; c < n; c++) {
            dp[c][c] = nums[c];

            for (int r = c - 1; r >= 0; r--) {
                dp[r][c] = Math.max(nums[r] - dp[r + 1][c], nums[c] - dp[r][c - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}
