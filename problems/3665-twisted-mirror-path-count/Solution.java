class Solution {
    int mod = (int) 1e9 + 7;
    Integer[][][] cache;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        cache = new Integer[m][n][2];

        return (recur(1, m - 2, n - 1, grid) + recur(0, m - 1, n - 2, grid)) % mod;
    }

    int recur(int d, int r, int c, int[][] grid) {
        if (r < 0 || c < 0) {
            return 0;
        }

        if (r == 0 && c == 0) {
            return 1;
        }

        if (cache[r][c][d] != null) {
            return cache[r][c][d];
        }

        int result;
        
        if (grid[r][c] == 1) {
            if (d == 0) {
                result = recur(1, r - 1, c, grid);
            } else {
                result = recur(0, r, c - 1, grid);
            }
        } else {
            result = (recur(1, r - 1, c, grid) + recur(0, r, c - 1, grid)) % mod;
        }

        return cache[r][c][d] = result;
    }
}
