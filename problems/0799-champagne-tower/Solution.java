class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 1];

        dp[0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = i; j >= 0; j--) {
                double spill = (dp[j] - 1) / 2;

                if (spill > 0) {
                    dp[j] = spill;
                    dp[j + 1] += spill;
                } else {
                    dp[j] = 0;
                }
            }
        }

        return Math.min(dp[query_glass], 1);
    }
}
