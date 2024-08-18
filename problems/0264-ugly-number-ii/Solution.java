class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;

        int two = 1;
        int three = 1;
        int five = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[two] * 2, Math.min(dp[three] * 3, dp[five] * 5));

            if (dp[i] == dp[two] * 2) {
                two++;
            }

            if (dp[i] == dp[three] * 3) {
                three++;
            }

            if (dp[i] == dp[five] * 5) {
                five++;
            }
        }

        return dp[n];
    }
}
