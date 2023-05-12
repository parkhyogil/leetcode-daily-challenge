class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;

        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];
            int brainPower = questions[i][1];
            int next = i + brainPower + 1;

            dp[i] = Math.max(dp[i + 1], point + (next < n ? dp[next] : 0));
        }
        return dp[0];
    }
}
