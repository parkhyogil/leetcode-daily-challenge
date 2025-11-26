class Solution {
    int mod = (int) 1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] cache = new int[m][n][k];
        for (int[][] a : cache) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        cache[0][0][grid[0][0] % k] = 1;

        return recur(m - 1, n - 1, 0, k, grid, cache);
    }

    int recur(int r, int c, int rem, int k, int[][] grid, int[][][] cache) {
        if (r < 0 || c < 0) {
            return 0;
        }

        if (cache[r][c][rem] != -1) {
            return cache[r][c][rem];
        }

        int prevRem = (rem - grid[r][c] % k + k) % k;

        return cache[r][c][rem] = (recur(r - 1, c, prevRem, k, grid, cache) + recur(r, c - 1, prevRem, k, grid, cache)) % mod; 
    }
}
