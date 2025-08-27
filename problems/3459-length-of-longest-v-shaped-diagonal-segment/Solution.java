class Solution {
    int[][] dir = new int[][] {
        {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
    };

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][][][] cache = new int[m][n][4][2];

        for (int[][][] a : cache) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    result = Math.max(result, recur(i + dir[k][0], j + dir[k][1], k, 0, grid[i][j], grid, cache) + 1);
                }
            }
        }

        return result;
    }

    int recur(int r, int c, int d, int turn, int prevVal, int[][] grid, int[][][][] cache) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length) {
            return 0;
        }

        if (cache[r][c][d][turn] != -1) {
            return cache[r][c][d][turn];
        }

        int val = grid[r][c];

        if ((prevVal == 1 && val != 2) || (prevVal == 2 && val != 0) || (prevVal == 0 && val != 2)) {
            return cache[r][c][d][turn] = 0;
        }

        int result = recur(r + dir[d][0], c + dir[d][1], d, turn, val, grid, cache) + 1;

        if (turn == 0) {
            int turnRight = (d + 1) % 4;

            result = Math.max(result, recur(r + dir[turnRight][0], c + dir[turnRight][1], turnRight, 1, val, grid, cache) + 1);
        }

        return cache[r][c][d][turn] = result;
    }
}
