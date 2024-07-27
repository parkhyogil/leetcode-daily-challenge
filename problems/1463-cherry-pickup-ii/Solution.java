class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] curr = new int[n][n];

        for (int r = m - 1; r >= 0; r--) {
            int[][] next = new int[n][n];

            for (int c1 = 0; c1 < n; c1++) {
                for (int c2 = 0; c2 < n; c2++) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (c1 + i >= 0 && c1 + i < n && c2 + j >= 0 && c2 + j < n) {
                                next[c1][c2] = Math.max(next[c1][c2], curr[c1 + i][c2 + j]);
                            }
                        }
                    }

                    next[c1][c2] += grid[r][c1] + grid[r][c2];
                    if (c1 == c2) {
                        next[c1][c2] -= grid[r][c1];
                    }
                }
            }

            curr = next;
        }

        return curr[0][n - 1];

        // int[][][] cache = new int[m][n][n];

        // for (int[][] a : cache) {
        //     for (int[] b : a) {
        //         Arrays.fill(b, -1);
        //     }
        // }

        // return recur(0, 0, n - 1, grid, cache);
    }

    private int recur(int r, int c1, int c2, int[][] grid, int[][][] cache) {
        if (r >= grid.length || c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length) {
            return 0;
        }

        if (cache[r][c1][c2] != -1) {
            return cache[r][c1][c2];
        }

        int res = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                res = Math.max(res, recur(r + 1, c1 + i, c2 + j, grid, cache));
            }
        }

        res += grid[r][c1] + grid[r][c2];
        if (c1 == c2) {
            res -= grid[r][c1];
        }

        return cache[r][c1][c2] = res;
    }
}
