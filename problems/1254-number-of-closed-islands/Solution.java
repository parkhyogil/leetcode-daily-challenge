class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(i, j, grid)) {
                    result++;
                }
            }
        }

        return result;
    }

    boolean dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length) {
            return false;
        }
        
        if (grid[r][c] == 1) {
            return true;
        }

        grid[r][c] = 1;

        boolean result = dfs(r - 1, c, grid);
        result &= dfs(r + 1, c, grid);
        result &= dfs(r, c - 1, grid);
        result &= dfs(r, c + 1, grid);

        return result;
    }
}
