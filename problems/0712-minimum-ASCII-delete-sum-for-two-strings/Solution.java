class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = dp[i][0] + (int) s1.charAt(i);
        }

        for (int i = 0; i < m; i++) {
            dp[0][i + 1] = dp[0][i] + (int) s2.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = (int) s1.charAt(i);
                int b = (int) s2.charAt(j);

                if (a == b) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(a + dp[i][j + 1], b + dp[i + 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
