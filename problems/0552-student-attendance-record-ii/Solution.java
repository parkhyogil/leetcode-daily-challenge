class Solution {
    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }

        int mod = (int) (1e9 + 7);

        long[][] dp = new long[n + 1][4];
        dp[0][3] = 1;

        dp[1][1] = dp[1][2] = 1;
        dp[1][3] = dp[1][1] + dp[1][2];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][2];
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][3] = (dp[i][0] + dp[i][1] + dp[i][2]) % mod;
        }

        long res = dp[n][3];

        for (int left = 0; left < n; left++) {
            int right = n - left - 1;

            res = (res + dp[left][3] * dp[right][3]) % mod;
        }

        return (int) (res % mod);
    }
}
