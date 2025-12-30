class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isMagicSquare(i, j, grid)) {
                    result++;
                }
            }
        }

        return result;
    }

    boolean isMagicSquare(int r, int c, int[][] grid) {
        if (grid[r + 1][c + 1] != 5) {
            return false;
        }

        int mask = 0;

        for (int i = 0; i < 3; i++) {
            int hSum = 0;
            int vSum = 0;

            for (int j = 0; j < 3; j++) {
                int val = grid[r + i][c + j];

                if (val == 0 || val > 9 || (mask & (1 << val)) > 0) {
                    return false;
                }

                mask |= 1 << val;
                hSum += val;
                vSum += grid[r + j][c + i];
            }

            if (hSum != 15 || vSum != 15) {
                return false;
            }
        }

        return true;
    }
}
