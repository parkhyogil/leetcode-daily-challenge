class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps / 2 + 1);

        int[] dp = new int[arrLen];
        dp[0] = 1;
        
        for (int i = 0; i < steps; i++) {
            int[] next = new int[arrLen];

            for (int j = 0; j < arrLen; j++) {
                int ways = dp[j];

                if (j - 1 >= 0) {
                    ways = (ways + dp[j - 1]) % MOD;
                }

                if (j + 1 < arrLen) {
                    ways = (ways + dp[j + 1]) % MOD;
                }

                next[j] = ways;
            }

            dp = next;
        }

        return dp[0];
    }
}
