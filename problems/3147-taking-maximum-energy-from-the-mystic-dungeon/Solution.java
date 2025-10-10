class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;

        int result = -10000;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = energy[i];

            if (i - k >= 0) {
                dp[i] = Math.max(dp[i], dp[i] + dp[i - k]);
            }

            if (i + k >= n) {
                result = Math.max(result, dp[i]);
            }
        }

        return result;
    }
}
