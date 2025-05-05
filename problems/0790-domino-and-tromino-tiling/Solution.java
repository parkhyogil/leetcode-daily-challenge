class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 9;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 % MOD + dp[i - 3]) % MOD;
        }

        return (dp[n] + MOD - dp[n - 1]) % MOD;
    }
}
