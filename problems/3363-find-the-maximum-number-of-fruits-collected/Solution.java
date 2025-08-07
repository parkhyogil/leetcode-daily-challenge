class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += fruits[i][i];
            fruits[i][i] = 0;
        }

        int[][] dp = new int[n][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, -100000);
        }
        
        dp[n - 1][0] = fruits[n - 1][0];

        for (int c = 1; c < n; c++) {
            for (int r = n - 1; r >= n / 2; r--) {
                dp[r][c] = fruits[r][c] + Math.max(dp[r][c - 1], Math.max(dp[r - 1][c - 1], (r + 1 < n ? dp[r + 1][c - 1] : 0)));
            }
        }

        sum += dp[n - 1][n - 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -100000);
        }

        dp[0][n - 1] = fruits[0][n - 1];

        for (int r = 1; r < n; r++) {
            for (int c = n - 1; c >= n / 2; c--) {
                dp[r][c] = fruits[r][c] + Math.max(dp[r - 1][c], Math.max(dp[r - 1][c - 1], (c + 1 < n ? dp[r - 1][c + 1] : 0)));
            }
        }

        return sum + dp[n - 1][n - 1];
    }
}
