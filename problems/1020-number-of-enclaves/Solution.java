class Solution {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(i, 0, grid);
            dfs(i, n - 1, grid);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, grid);
            dfs(m - 1, i, grid);
        }

        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        for (int[] d : dir) {
            dfs(r + d[0], c + d[1], grid);
        }
    }
}
