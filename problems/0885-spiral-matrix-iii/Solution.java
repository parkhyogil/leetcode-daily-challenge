class Solution {
    private final int[][] dir = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][];
        int idx = 0;

        result[idx++] = new int[] {rStart, cStart};

        int row = rStart - 1;
        int col = cStart + 1;

        int length = 2;

        while (idx < result.length) {
            for (int[] d : dir) {
                for (int i = 0; i < length; i++) {
                    row += d[0];
                    col += d[1];

                    if (isInBoundary(row, col, rows, cols)) {
                        result[idx++] = new int[] {row, col};
                    }
                }
            }

            row--;
            col++;
            length += 2;
        }

        return result;
    }

    private boolean isInBoundary(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
