class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long result = Long.MIN_VALUE;
        long[][] dp = new long[n][3];
        
        Arrays.fill(dp[0], Long.MIN_VALUE / 2);
        
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            Arrays.fill(dp[i], Long.MIN_VALUE / 2);

            if (num > nums[i - 1]) {
                dp[i][0] = Math.max(nums[i - 1], dp[i - 1][0]) + num;
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]) + num;
            } else if (num < nums[i - 1]) {
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + num;
            }

            result = Math.max(result, dp[i][2]);
        }

        return result;
    }
}
