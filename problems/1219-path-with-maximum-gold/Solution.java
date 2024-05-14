class Solution {
    private int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visit = new boolean[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, recur(i, j, grid, visit));
                }
            }
        }

        return res;
    }

    private int recur(int r, int c, int[][] grid, boolean[][] visit) {
        visit[r][c] = true;

        int res = grid[r][c];

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (isOutOfBoundary(nr, nc) || grid[nr][nc] == 0 || visit[nr][nc]) {
                continue;
            }

            res = Math.max(res, grid[r][c] + recur(nr, nc, grid, visit));
        }

        visit[r][c] = false;

        return res;
    }

    private boolean isOutOfBoundary(int r, int c) {
        return r < 0 || r == m || c < 0 || c == n;
    }
}
