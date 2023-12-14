class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] oneRow = new int[m];
        int[] oneCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneRow[i]++;
                    oneCol[j]++;
                }
            }
        }

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 2 * (oneRow[i] + oneCol[j]) - m - n;
            }
        }

        return res;
    }
}
