class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] rows = new long[m];
        long[] cols = new long[n];

        long t = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t += grid[i][j];
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }

        long sum = 0;
        for (int i = 0; i < m - 1; i++) {
            sum += rows[i];

            if (sum == t - sum) {
                return true;
            }
        }

        sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += cols[i];

            if (sum == t - sum) {
                return true;
            }
        }

        return false;
    }
}
