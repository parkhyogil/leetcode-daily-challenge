class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }

        for (int len = Math.min(m, n); len > 1; len--) {
            for (int i = 0; i + len <= m; i++) {
                for (int j = 0; j + len <= n; j++) {
                    int sum = rowSum[i][j + len] - rowSum[i][j];
                    int ds0 = 0;
                    int ds1 = 0;

                    boolean find = true;

                    for (int k = 0; k < len && find; k++) {
                        find &= sum == rowSum[i + k][j + len] - rowSum[i + k][j] && sum == colSum[i + len][j + k] - colSum[i][j + k];
                        ds0 += grid[i + k][j + k];
                        ds1 += grid[i + k][j + len - 1 - k];
                    }

                    find &= ds0 == sum && ds1 == sum;

                    if (find) {
                        return len;
                    }
                }
            }
        }

        return 1;
    }
}
