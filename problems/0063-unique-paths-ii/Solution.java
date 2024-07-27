class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return recur(m - 1, n - 1, obstacleGrid, memo);
    }

    private int recur(int r, int c, int[][] grid, int[][] memo) {
        if (r < 0 || c < 0 || grid[r][c] == 1) {
            return 0;
        }

        if (r == 0 && c == 0) {
            return 1;
        }

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        return memo[r][c] = recur(r - 1, c, grid, memo) + recur(r, c - 1, grid, memo);
    }
}
