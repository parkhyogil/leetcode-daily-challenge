class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] dp = new long[n];

        for (int r = 0; r < m; r++) {
            long max = 0;

            for (int c = 0; c < n; c++) {
                dp[c] = Math.max(dp[c], max - 1);
                max = Math.max(max - 1, dp[c]);
            }

            for (int c = n - 1; c >= 0; c--) {
                dp[c] = Math.max(dp[c], max - 1);
                max = Math.max(max - 1, dp[c]);
            }

            for (int c = 0; c < n; c++) {
                dp[c] += points[r][c];
            }
        }

        long result = 0L;

        for (long point : dp) {
            result = Math.max(result, point);
        }

        return result;
    }
}
