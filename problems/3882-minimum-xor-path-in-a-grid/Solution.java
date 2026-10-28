class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] d = new boolean[n][1024];
        d[0][grid[0][0]] = true;
        int x = grid[0][0];

        for (int i = 1; i < n; i++) {
            x ^= grid[0][i];
            d[i][x] = true;
        }

        x = grid[0][0];

        for (int i = 1; i < m; i++) {
            boolean[][] nd = new boolean[n][1024];

            x ^= grid[i][0];
            nd[0][x] = true;

            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 1024; k++) {
                    if (nd[j - 1][k]) {
                        nd[j][k ^ grid[i][j]] = true;
                    }
                    if (d[j][k]) {
                        nd[j][k ^ grid[i][j]] = true;
                    }
                }
            }

            d = nd;
        }

        for (int i = 0; i < 1024; i++) {
            if (d[n - 1][i]) {
                return i;
            }
        }

        return -1;
    }
}
