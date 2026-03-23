class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][][] dp = new long[m][n][2];
        dp[0][0] = new long[] {grid[0][0], grid[0][0]};

        for (int i = 1; i < m; i++) {
            long x = grid[i][0] * dp[i - 1][0][0];

            dp[i][0] = new long[] {x, x};
        }

        for (int i = 1; i < n; i++) {
            long x = grid[0][i] * dp[0][i - 1][0];
            dp[0][i] = new long[] {x, x};
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int v = grid[i][j];

                dp[i][j][0] = Math.max(
                    Math.max(v * dp[i - 1][j][0], v * dp[i - 1][j][1]), 
                    Math.max(v * dp[i][j - 1][0], v * dp[i][j - 1][1])
                );
                dp[i][j][1] = Math.min(
                    Math.min(v * dp[i - 1][j][0], v * dp[i - 1][j][1]), 
                    Math.min(v * dp[i][j - 1][0], v * dp[i][j - 1][1])
                );
            }
        }

        return Math.max((int) (dp[m - 1][n - 1][0] % 1000000007), -1);
    }
}
