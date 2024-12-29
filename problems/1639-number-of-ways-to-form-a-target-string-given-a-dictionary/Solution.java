class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int n = target.length();
        int m = words[0].length();

        int[][] charCount = new int[m][26];

        for (String word : words) {
            for (int i = 0; i < m; i++) {
                charCount[i][word.charAt(i) - 'a']++;
            }
        }

        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], 1L);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                dp[i + 1][j + 1] = (dp[i + 1][j] + dp[i][j] * charCount[j][target.charAt(i) - 'a']) % MOD;
            }
        }

        return (int) dp[n][m];
    }
}
