class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i *= 2) {
            for (int j = 0; j < i && i + j <= n; j++) {
                dp[i + j] = dp[j] + 1;
            }
        }

        return dp;
    }
}
