class Solution {
    private int m, n;
    private int[][] grid;

    public int minDays(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        if (countIsland() != 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                grid[i][j] = 0;

                if (countIsland() != 1) {
                    return 1;
                }
                
                grid[i][j] = 1;
            }
        }

        return 2;
    }

    private int countIsland() {
        boolean[][] visit = new boolean[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    result++;
                    dfs(i, j, visit);
                }
            }
        }
        
        return result;
    }

    private void dfs(int r, int c, boolean[][] visit) {
        if (isOutOfBoundary(r, c) || grid[r][c] == 0 || visit[r][c]) {
            return;
        }
        visit[r][c] = true;

        dfs(r + 1, c, visit);
        dfs(r - 1, c, visit);
        dfs(r, c + 1, visit);
        dfs(r, c - 1, visit);
    }

    private boolean isOutOfBoundary(int r, int c) {
        return r < 0 || c < 0 || r == m || c == n;
    }
}
