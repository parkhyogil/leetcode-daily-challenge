class Solution {
    public int countVowelPermutation(int n) {
        int MOD = (int) 1e9 + 7;

        int[] dp = new int[5];
        Arrays.fill(dp, 1);

        for (int j = 1; j < n; j++) {
            int a = dp[1];
            int e = (dp[0] + dp[2]) % MOD;
            int i = ((dp[0] + dp[1]) % MOD + (dp[3] + dp[4]) % MOD) % MOD;
            int o = (dp[2] + dp[4]) % MOD;
            int u = dp[0];

            dp[0] = a;
            dp[1] = e;
            dp[2] = i;
            dp[3] = o;
            dp[4] = u;
        }

        int res = 0;
        for (int count : dp) {
            res = (res + count) % MOD;
        }
        return res;
    }
}
