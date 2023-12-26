class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) 1e9 + 7;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] next = new int[target + 1];
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k && j - l >= 0; l++) {
                    next[j] += dp[j - l];
                    next[j] %= mod;
                }
            }
            dp = next;
        }

        return dp[target];
    }
}
