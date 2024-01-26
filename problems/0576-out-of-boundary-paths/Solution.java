class Solution {
    private int[][] dir = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    private int mod = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] cache = new int[m][n][maxMove + 1];

        for (int[][] i : cache) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        return recur(startRow, startColumn, m, n, maxMove, cache);
    }

    private int recur(int r, int c, int m, int n, int move, int[][][] cache) {
        if (isOutOfBoundary(r, c, m, n)) {
            return 1;
        }

        if (move == 0) {
            return 0;
        }

        if (cache[r][c][move] != -1) {
            return cache[r][c][move];
        }

        int res = 0;
        for (int[] d : dir) {
            res = (res + recur(r + d[0], c + d[1], m, n, move - 1, cache)) % mod;
        }
        return cache[r][c][move] = res;
    }

    private boolean isOutOfBoundary(int r, int c, int m, int n) {
        return r < 0 || r == m || c < 0 || c == n;
    }
}
