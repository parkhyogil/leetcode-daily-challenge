class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        double[][] dp = new double[n][n];
        dp[row][column] = 1;

        while (k-- > 0) {
            double[][] next = new double[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] == 0) {
                        continue;
                    }
                    
                    for (int[] d : dir) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                            continue;
                        }

                        next[nr][nc] += dp[r][c] / 8;
                    }
                }
            }
            dp = next;
        }

        double res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }
}
