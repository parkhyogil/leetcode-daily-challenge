class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i + 1] = Integer.MAX_VALUE;

            for (int j = i; j >= 0 && days[i] - days[j] < 30; j--) {
                int diff = days[i] - days[j];

                if (diff < 1) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + costs[0]);
                }

                if (diff < 7) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + costs[1]);
                }

                if (diff < 30) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + costs[2]);
                }
            }
        }

        return dp[n];
    }
}
