class Solution {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(i, j, grid)) {
                    res++;
                }
            }
        }    
        return res;
    }

    private boolean dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        }
        grid[r][c] = 1;
        boolean res = true;
        for (int[] d : dir) {
            res &= dfs(r + d[0], c + d[1], grid);
        }
        return res;
    }
}
