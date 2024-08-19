class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = n + 1;

            for (int j = 1; j * j <= i; j++) {
                if (i % j != 0) {
                    continue;
                }

                int k = i / j;
                
                dp[i] = Math.min(dp[i], Math.min(dp[j] + 1 + ((i - j) / j), dp[k] + 1 + ((i - k) / k)));
            }
        }

        return dp[n];
    }
}
