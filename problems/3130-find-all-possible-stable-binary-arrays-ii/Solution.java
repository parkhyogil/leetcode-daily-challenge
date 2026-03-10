class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = (int) 1e9 + 7;
        int L = limit + 1;

        int[][][] dp = new int[zero + 1][one + 1][2];
        for (int i = 0; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 0; i <= Math.min(one, limit); i++) {
            dp[0][i][1] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1] - (i >= L ? dp[i - L][j][1] : 0)) % mod;
                dp[i][j][1] = (dp[i][j - 1][1] + dp[i][j - 1][0] - (j >= L ? dp[i][j - L][0] : 0)) % mod;

                dp[i][j][0] = (dp[i][j][0] + mod) % mod;
                dp[i][j][1] = (dp[i][j][1] + mod) % mod;
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}
