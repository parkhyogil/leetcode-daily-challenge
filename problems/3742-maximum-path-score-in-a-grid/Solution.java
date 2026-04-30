class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        k = Math.min(k, m + n);

        int[][] dp = new int[n][k + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int[] next = new int[k + 1];
                int v = grid[i][j];
                for (int l = 0; l <= k; l++) {
                    int max = -1;

                    if (i > 0 && (v == 0 || l > 0) && dp[j][v == 0 ? l : l - 1] >= 0) {
                        max = dp[j][v == 0 ? l : l - 1] + v;
                    }
                    if (j > 0 && (v == 0 || l > 0) && dp[j - 1][v == 0 ? l : l - 1] >= 0) {
                        max = Math.max(max, dp[j - 1][v == 0 ? l : l - 1] + v);
                    }
                    
                    next[l] = max;
                }

                dp[j] = next;
            }
        }

        int result = -1;

        for (int i = 0; i <= k; i++) {
            result = Math.max(result, dp[n - 1][i]);
        }

        return result;
    }
}
