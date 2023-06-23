class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        int res = 0;
        int[][] dp = new int[n][1001];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];

                dp[i][diff + 500] = dp[j][diff + 500] + 1;
                res = Math.max(res, dp[i][diff + 500]);
            }
        }
        return res + 1;
    }
}
