class Solution {
    private int mod = (int) 1e9 + 7;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int m, n;
    private int[][] grid, memo;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        this.grid = grid;
        this.memo = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + recur(i, j)) % mod;
            }
        }
        return res;
    }

    private int recur(int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        
        int res = 1;
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (isOutOfBoundary(nr, nc) || grid[nr][nc] <= grid[r][c]) {
                continue;
            }

            res = (res + recur(nr, nc)) % mod;
        }
        return memo[r][c] = res;
    }

    private boolean isOutOfBoundary(int r, int c) {
        return r < 0 || c < 0 || r >= m || c >= n;
    }
}
