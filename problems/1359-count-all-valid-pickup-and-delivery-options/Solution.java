class Solution {
    public int countOrders(int n) {
        int mod = (int) 1e9 + 7;

        long[] dp = new long[n + 1];

        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int j = i * 2 - 1;
            dp[i] = (dp[i - 1] * j * (j + 1) / 2) % mod;
        }
        
        return (int) dp[n];
    }
}
