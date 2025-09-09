class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = (int) 1e9 + 7;

        int[] dp = new int[n + 1];
        dp[1 + delay]++;
        if (1 + forget <= n) {
            dp[1 + forget]--;
        }
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i] + dp[i - 1]) % mod;

            if (i + delay <= n) {
                dp[i + delay] = (dp[i + delay] + dp[i]) % mod;
            }

            if (i + forget <= n) {
                dp[i + forget] = (dp[i + forget] - dp[i] + mod) % mod;
            }
        }

        dp[1] = 1;

        int result = 0;

        for (int i = n; i > n - forget; i--) {
            result = (result + dp[i]) % mod;
        }

        return result;
    }
}
