class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int tmpRow = -1;
        int tmpCol = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }
                if (tmpRow == -1) {
                    tmpRow = i;
                    tmpCol = j;
                } else {
                    matrix[tmpRow][j] = 0;
                    matrix[i][tmpCol] = 0;
                }
            }
        }

        if (tmpRow == -1) {
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != tmpRow && j != tmpCol && (matrix[tmpRow][j] == 0 || matrix[i][tmpCol] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            matrix[i][tmpCol] = 0;
        }

        for (int i = 0; i < n; i++) {
            matrix[tmpRow][i] = 0;
        }
    }
}
