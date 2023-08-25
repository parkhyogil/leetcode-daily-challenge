class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 + l2 != s3.length()) {
            return false;
        }

        int[][] memo = new int[l1 + 1][l2 + 1];
        return recur(0, 0, 0, s1, s2, s3, memo);
    }

    private boolean recur(int i, int j, int k, String s1, String s2, String s3, int[][] memo) {
        if (k == s3.length()) {
            return true;
        }

        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }

        boolean res = (i < s1.length() && s1.charAt(i) == s3.charAt(k) && recur(i + 1, j, k + 1, s1, s2, s3, memo)) 
                    || (j < s2.length() && s2.charAt(j) == s3.charAt(k) && recur(i, j + 1, k + 1, s1, s2, s3, memo));

        memo[i][j] = res ? 1 : -1;
        return res;
    }
}
