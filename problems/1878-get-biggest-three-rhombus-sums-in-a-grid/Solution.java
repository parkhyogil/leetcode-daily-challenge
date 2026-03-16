class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int m0 = 0, m1 = 0, m2 = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = grid[i][j];
                if (!(tmp == m0 || tmp == m1 || tmp == m2)) {
                    if (tmp > m0) {
                        m2 = m1;
                        m1 = m0;
                        m0 = tmp;
                    } else if (tmp > m1) {
                        m2 = m1;
                        m1 = tmp;
                    } else if (tmp > m2) {
                        m2 = tmp;
                    }
                }

                for (int k = 1; i + k * 2 < m && j - k >= 0 && j + k < n; k++) {
                    tmp += grid[i + k][j - k] + grid[i + k][j + k];

                    int sum = tmp;
                    for (int l = 1; l < k; l++) {
                        sum += grid[i + k + l][j - k + l] + grid[i + k + l][j + k - l];
                    }
                    sum += grid[i + k * 2][j];

                    if (sum == m0 || sum == m1 || sum == m2) {
                        continue;
                    }

                    if (sum > m0) {
                        m2 = m1;
                        m1 = m0;
                        m0 = sum;
                    } else if (sum > m1) {
                        m2 = m1;
                        m1 = sum;
                    } else if (sum > m2) {
                        m2 = sum;
                    }
                }
            }
        }

        if (m1 == 0) {
            return new int[] {m0};
        }
        if (m2 == 0) {
            return new int[] {m0, m1};
        }
        return new int[] {m0, m1, m2};
    }
}
