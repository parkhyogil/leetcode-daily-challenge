class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[n][m];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res[c][r] = matrix[r][c];
            }
        }

        return res;
    }
}
