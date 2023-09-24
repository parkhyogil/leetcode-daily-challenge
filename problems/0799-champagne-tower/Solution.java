class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];

        dp[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j < query_row; j++) {
                if (dp[i][j] <= 1) {
                    continue;
                }

                double overflow = dp[i][j] - 1;
                dp[i + 1][j] += overflow / 2;
                dp[i + 1][j + 1] += overflow / 2;
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }
}
