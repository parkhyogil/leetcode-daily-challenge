class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int r0 = m, r1 = 0, c0 = n, c1 = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    r0 = Math.min(r0, i);
                    r1 = Math.max(r1, i);
                    c0 = Math.min(c0, j);
                    c1 = Math.max(c1, j);
                }
            }
        }

        return (r1 - r0 + 1) * (c1 - c0 + 1);
    }
}
