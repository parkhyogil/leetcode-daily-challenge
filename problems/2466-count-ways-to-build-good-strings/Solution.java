class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = calculateDpTable(high, zero, one);

        int result = 0;

        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % MOD;
        }

        return result;
    }

    private int[] calculateDpTable(int n, int zero, int one) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i - zero >= 0) {
                dp[i] += dp[i - zero];
            }

            if (i - one >= 0) {
                dp[i] += dp[i - one];
            }

            dp[i] %= MOD;
        }

        return dp;
    }
}
