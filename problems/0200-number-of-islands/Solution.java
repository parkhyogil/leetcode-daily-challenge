class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    recur(i, j, grid);
                }
            }
        }

        return res;
    }

    private void recur(int r, int c, char[][] grid) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        recur(r + 1, c, grid);
        recur(r - 1, c, grid);
        recur(r, c + 1, grid);
        recur(r, c - 1, grid);
    }
}
