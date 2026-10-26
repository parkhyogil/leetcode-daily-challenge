class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long x = dfs(i, j, grid);

                if (x > 0 && x % k == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    long dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        long result = grid[r][c];
        grid[r][c] = 0;

        result += dfs(r + 1, c, grid) + dfs(r - 1, c, grid) + dfs(r, c + 1, grid) + dfs(r, c - 1, grid);

        return result;
    }
}
