class Solution {
    public int numberOfWays(int n, int x) {
        int mod = (int) 1e9 + 7;
    
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int p = (int) Math.pow(i, x);

            for (int k = n; k >= p; k--) {
                dp[k] = (dp[k] + dp[k - p]) % mod;
            }
        }

        return dp[n];
    }
}
