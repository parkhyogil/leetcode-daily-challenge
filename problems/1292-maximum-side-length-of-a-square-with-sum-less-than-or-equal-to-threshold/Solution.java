class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] sum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + mat[i][j];
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = Math.min(i, j) + 1; l > result; l--) {
                    if (threshold >= sum[i + 1][j + 1] - sum[i + 1 - l][j + 1] - sum[i + 1][j + 1 -l] + sum[i + 1 - l][j + 1 -l]) {
                        result = Math.max(result, l);
                    }
                }
            }
        }

        return result;
    }
}
