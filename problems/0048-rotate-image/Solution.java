class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int s = 0, e = n - 1; s < e; s++, e--) {
            for (int i = s, j = e; i < e; i++, j--) {
                int t = matrix[s][i];
                matrix[s][i] = matrix[j][s];
                matrix[j][s] = matrix[e][j];
                matrix[e][j] = matrix[i][e];
                matrix[i][e] = t;
            }
        }
    }
}
