class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n];

        for (int c = 0; c < n; c++) {
            dp[c][c] = piles[c];

            for (int r = c - 1; r >= 0; r--) {
                dp[r][c] = Math.max(piles[r] - dp[r + 1][c], piles[c] - dp[r][c - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
