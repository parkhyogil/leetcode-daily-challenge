class Solution {
    int mod = (int) 1e9 + 7;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[zero + 1][one + 1][2];

        for (int i = 0; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 0; i <= Math.min(one, limit); i++) {
            dp[0][i][1] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                for (int k = 1; k <= limit; k++) {
                    if (i >= k) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - k][j][1]) % mod;
                    }
                    if (j >= k) {
                        dp[i][j][1] = (dp[i][j][1] + dp[i][j - k][0]) % mod;
                    }
                }
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}
