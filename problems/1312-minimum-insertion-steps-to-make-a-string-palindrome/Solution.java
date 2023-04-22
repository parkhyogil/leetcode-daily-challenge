class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int[][] memo = new int[n][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return recur(0, n - 1, s, memo);
    }

    private int recur(int l, int r, String s, int[][] memo) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        if (s.charAt(l) == s.charAt(r)) {
            memo[l][r] = recur(l + 1, r - 1, s, memo);
        } else {
            memo[l][r] = Math.min(recur(l + 1, r, s, memo), recur(l, r - 1, s, memo)) + 1;
        }
        return memo[l][r];
    }
}
