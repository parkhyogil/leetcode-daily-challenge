class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = (m + n - 2) * 2;

        int[][] result = new int[m][n];

        for (int l = 0; l < Math.min(m, n) / 2; l++) {
            for (int i = 0; i < len; i++) {
                int[] a = get(l, m - 1 - l, l, n - 1 - l, m - 2 * l, n - 2 * l, i);
                int[] b = get(l, m - 1 - l, l, n - 1 - l, m - 2 * l, n - 2 * l, (i + k) % len);

                result[a[0]][a[1]] = grid[b[0]][b[1]];
            }

            len -= 8;
        }

        return result;
    }

    int[] get(int r0, int r1, int c0, int c1, int m, int n, int i) {
        if (c0 + i < c1) {
            return new int[] {r0, c0 + i};
        }
        if (r0 + (i - n + 1) < r1) {
            return new int[] {r0 + (i - n + 1), c1};
        }
        if (c0 < c1 - (i - n - m + 2)) {
            return new int[] {r1, c1 - (i - n - m + 2)};
        }
        return new int[] {r1 - (i - m - 2 * n + 3), c0};
    }
}
