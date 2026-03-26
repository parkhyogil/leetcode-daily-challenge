class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;
        for (int[] row : grid) {
            for (int x : row) {
                max = Math.max(x, max);
            }
        }

        int[] freq = new int[max + 1];
        long t = 0;

        for (int[] row : grid) {
            for (int x : row) {
                freq[x]++;
                t += x;
                max = Math.max(x, max);
            }
        }

        long sum = 0;
        int[] f = new int[max + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                f[grid[i][j]]++;
            }

            long diff = t - sum;
            if (diff == sum) {
                return true;
            }

            if (Math.abs(diff - sum) > max) {
                continue;
            }

            int d = (int) (diff - sum);

            if (d > 0) {
                if (freq[d] - f[d] == 0) {
                    continue;
                }
                if (n > 1 && (i < m - 2 || grid[m - 1][0] == d || grid[m - 1][n - 1] == d)) {
                    return true;
                }
                if (n == 1 && (grid[i + 1][0] == d || grid[m - 1][0] == d)) {
                    return true;
                }
            } else {
                d = Math.abs(d);
                if (f[d] == 0) {
                    continue;
                }
                if (n > 1 && (i > 0 || grid[0][0] == d || grid[0][n - 1] == d)) {
                    return true;
                }
                if (n == 1 && (grid[0][0] == d || grid[i][0] == d)) {
                    return true;
                }
            }
        }

        sum = 0;
        Arrays.fill(f, 0);
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
                f[grid[i][j]]++;
            }

            long diff = t - sum;
            if (diff == sum) {
                return true;
            }

            if (Math.abs(diff - sum) > max) {
                continue;
            }

            int d = (int) (diff - sum);

            if (d > 0) {
                if (freq[d] - f[d] == 0) {
                    continue;
                }
                if (m > 1 && (j < n - 2 || grid[0][n - 1] == d || grid[m - 1][n - 1] == d)) {
                    return true;
                }
                if (m == 1 && (grid[0][j + 1] == d || grid[0][n - 1] == d)) {
                    return true;
                }
            } else {
                d = Math.abs(d);
                if (f[d] == 0) {
                    continue;
                }
                if (m > 1 && (j > 0 || grid[0][0] == d || grid[m - 1][0] == d)) {
                    return true;
                }
                if (m == 1 && (grid[0][0] == d || grid[0][j] == d)) {
                    return true;
                }
            }
        }

        return false;
    }
}
