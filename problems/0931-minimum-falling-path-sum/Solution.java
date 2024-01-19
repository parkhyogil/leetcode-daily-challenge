class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;


        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int min = matrix[r - 1][c];

                if (c > 0) {
                    min = Math.min(min, matrix[r - 1][c - 1]);
                }

                if (c < n - 1) {
                    min = Math.min(min, matrix[r - 1][c + 1]);
                }

                matrix[r][c] += min;
            }
        }

        int res = Integer.MAX_VALUE;

        for (int c = 0; c < n; c++) {
            res = Math.min(res, matrix[n - 1][c]);
        }
        
        return res;
    }
}
