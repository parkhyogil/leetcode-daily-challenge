class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        long[][][] dp = new long[n + 1][k + 1][3];

        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = dp[0][i][2] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int p = prices[i];

            for (int j = 0; j < k; j++) {
                dp[i + 1][j + 1][1] = Math.max(dp[i][j + 1][1], dp[i][j][0] - p);
                dp[i + 1][j + 1][2] = Math.max(dp[i][j + 1][2], dp[i][j][0] + p);

                dp[i + 1][j + 1][0] = Math.max(dp[i][j + 1][0], Math.max(dp[i][j + 1][1] + p, dp[i][j + 1][2] - p));
            }
        }

        return dp[n][k][0];
    }
}
