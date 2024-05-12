class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = getMaxLocal(grid, i, j);
            }
        }

        return res;
    }

    private int getMaxLocal(int[][] grid, int i, int j) {
        int max = 0;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                max = Math.max(max, grid[k][l]);
            }
        }
        return max;
    }
}
