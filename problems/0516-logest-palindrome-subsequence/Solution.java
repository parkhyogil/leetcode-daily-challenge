class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        return recur(0, n - 1, s, new int[n][n]);
    }

    private int recur(int left, int right, String s, int[][] memo) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int res = 0;
        if (s.charAt(left) == s.charAt(right)) {
            res = recur(left + 1, right - 1, s, memo) + 2;
        } else {
            res = Math.max(recur(left + 1, right, s, memo), recur(left, right - 1, s, memo));
        }
        return memo[left][right] = res;
    }
}
