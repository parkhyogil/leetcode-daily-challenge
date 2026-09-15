class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        boolean[][] p = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                p[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 >= j - 1 || p[i + 1][j - 1]);
            }
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int max = i == 0 ? 0 : dp[i - 1];

            for (int j = i - k + 1; j >= 0; j--) {
                if (p[j][i]) {
                    max = Math.max(max, 1 + (j == 0 ? 0 : dp[j - 1]));
                }
            }

            dp[i] = max;
        }

        return dp[n - 1];
    }
}
