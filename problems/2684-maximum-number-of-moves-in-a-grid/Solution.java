class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int c = n - 2; c >= 0; c--) {
            for (int r = 0; r < m; r++) {
                int maxMove = 0;

                if (r - 1 >= 0 && grid[r - 1][c + 1] > grid[r][c]) {
                    maxMove = Math.max(maxMove, dp[r - 1][c + 1] + 1);
                }

                if (grid[r][c + 1] > grid[r][c]) {
                    maxMove = Math.max(maxMove, dp[r][c + 1] + 1);
                }

                if (r + 1 < m && grid[r + 1][c + 1] > grid[r][c]) {
                    maxMove = Math.max(maxMove, dp[r + 1][c + 1] + 1);
                }

                dp[r][c] = maxMove;
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            result = Math.max(result, dp[i][0]);
        }

        return result;
    }
}
