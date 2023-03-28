class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n && days[j] < days[i] + 1; j++) {
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + costs[0]);
            }
            for (int j = i; j < n && days[j] < days[i] + 7; j++) {
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + costs[1]);
            }
            for (int j = i; j < n && days[j] < days[i] + 30; j++) {
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + costs[2]);
            }
        }
        return dp[n];
    }
}
