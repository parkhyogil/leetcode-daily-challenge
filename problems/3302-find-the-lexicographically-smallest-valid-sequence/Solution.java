class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            if (dp[i + 1] < n && word1.charAt(i) == word2.charAt(n - 1 - dp[i + 1])) {
                dp[i] = dp[i + 1] + 1;
            } else {
                dp[i] = dp[i + 1];
            }
        }

        int[] result = new int[n];
        boolean changed = false;

        int j = 0;

        for (int i = 0; i < m && j < n; i++) {
            char a = word1.charAt(i);
            char b = word2.charAt(j);

            if (a == b) {
                result[j] = i;
                j++;
            } else if (!changed && dp[i + 1] >= n - j - 1) {
                result[j] = i;
                j++;
                changed = true;
            }
        }

        return j < n ? new int[0] : result;
    }
}
