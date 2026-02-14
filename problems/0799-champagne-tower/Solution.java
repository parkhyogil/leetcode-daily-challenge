class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_glass + 2];

        dp[0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = Math.min(i, query_glass); j >= 0; j--) {
                double spill = dp[j] - 1;

                if (spill > 0) {
                    dp[j + 1] += spill / 2;
                    dp[j] = spill / 2;
                } else {
                    dp[j] = 0;
                }
            }
        }

        return Math.min(dp[query_glass], 1);
    }
}
