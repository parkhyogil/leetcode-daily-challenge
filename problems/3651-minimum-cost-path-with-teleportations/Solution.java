class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] cost = new int[m][n];
        int max = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                cost[r][c] = Integer.MAX_VALUE / 2;
                max = Math.max(max, grid[r][c]);
            }
        }
        cost[0][0] = 0;

        int[] minSuff = new int[max + 1];
        Arrays.fill(minSuff, Integer.MAX_VALUE);

        for (int i = 0; i <= k; i++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int v = grid[r][c];

                    if (r > 0) {
                        cost[r][c] = Math.min(cost[r][c], cost[r - 1][c] + v);
                    }
                    if (c > 0) {
                        cost[r][c] = Math.min(cost[r][c], cost[r][c - 1] + v);
                    }

                    minSuff[v] = Math.min(minSuff[v], cost[r][c]);
                }
            }

            if (i == k) {
                break;
            }

            for (int j = max - 1; j >= 0; j--) {
                minSuff[j] = Math.min(minSuff[j], minSuff[j + 1]);
            }

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    cost[r][c] = Math.min(cost[r][c], minSuff[grid[r][c]]);
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
