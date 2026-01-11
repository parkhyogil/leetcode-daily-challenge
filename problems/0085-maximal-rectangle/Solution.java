class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] count = new int[m][n];

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                count[i][j]++;

                if (j > 0) {
                    count[i][j] += count[i][j - 1];
                }

                int min = count[i][j];

                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, count[k][j]);

                    if (min == 0) {
                        break;
                    }
                    
                    result = Math.max(result, min * (i - k + 1));
                }
            }
        }

        return result;
    }
}
