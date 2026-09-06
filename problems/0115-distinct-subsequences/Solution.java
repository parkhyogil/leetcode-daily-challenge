class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (j + 1 == n) {
                        dp[i][j]++;
                    } else if (i + 1 < m) {
                        dp[i][j] += dp[i + 1][j + 1];
                    }
                }
                if (i + 1 < m) {
                    dp[i][j] += dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
