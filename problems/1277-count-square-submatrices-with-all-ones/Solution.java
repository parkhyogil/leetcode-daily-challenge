class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            result += matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            result += matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));

                result += matrix[i][j];                
            }
        }

        return result;
    }
}
