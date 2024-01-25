class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] cache = new int[m][n];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return recur(m - 1, n - 1, text1, text2, cache);
    }

    private int recur(int i, int j, String s1, String s2, int[][] cache) {
        if (i < 0 || j < 0) {
            return 0;
        }
        
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int res = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            res = 1 + recur(i - 1, j - 1, s1, s2, cache);
        } else {
            res = Math.max(recur(i - 1, j, s1, s2, cache), recur(i, j - 1, s1, s2, cache));
        }

        return cache[i][j] = res;
    }
}
