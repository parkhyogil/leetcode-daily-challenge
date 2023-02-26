class Solution {
    public int minDistance(String word1, String word2) {
        return recur(0, 0, word1, word2, new Integer[word1.length()][word2.length()]);
    }

    private int recur(int i, int j, String s1, String s2, Integer[][] memo) {
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }
        if (i == s1.length()) {
            return s2.length() - j;
        }
        if (j == s2.length()) {
            return s1.length() - i;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = recur(i + 1, j + 1, s1, s2, memo);
        }
        return memo[i][j] = Math.min(recur(i, j + 1, s1, s2, memo), Math.min(recur(i + 1, j, s1, s2, memo), recur(i + 1, j + 1, s1, s2, memo))) + 1;
    }
}
