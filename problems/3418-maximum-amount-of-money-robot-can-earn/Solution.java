class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];
        dp[0][0][0] = coins[0][0];
        dp[0][0][1] = dp[0][0][2] = Math.max(coins[0][0], 0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++){
                dp[0][i][j] = Math.max(coins[0][i] + dp[0][i - 1][j], j > 0 ? dp[0][i - 1][j - 1] : Integer.MIN_VALUE);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0][j] = Math.max(coins[i][0] + dp[i - 1][0][j], j > 0 ? dp[i - 1][0][j - 1] : Integer.MIN_VALUE);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Math.max(
                        coins[i][j] + Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), 
                        k > 0 ? Math.max(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1]) : Integer.MIN_VALUE);
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
