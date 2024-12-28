class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length - k + 1;

        int[] subarraySums = getSubarraySumArray(n, k, nums);
        int[][] dp = getDpTable(k, n, subarraySums);

        int[] result = new int[3];
        
        for (int idx = 2, i = 3, j = n - 1; idx >= 0 && i > 0 && j >= 0; ) {
            if (j == 0 || dp[i][j] > dp[i][j - 1]) {
                result[idx--] = j;
                i--;
                j -= k;
            } else {
                j--;
            }
        }

        return result;
    }

    int[][] getDpTable(int k, int n, int[] subarraySums) {
        int[][] dp = new int[4][n];

        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = subarraySums[j];
                if (j - k >= 0) {
                    dp[i][j] += dp[i - 1][j - k];
                }

                if (j > 0 && dp[i][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp;
    }

    int[] getSubarraySumArray(int n, int k, int[] nums) {
        int[] subarraySums = new int[n];

        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            sum += nums[i + k - 1];
            subarraySums[i] = sum;
            sum -= nums[i];
        }
        return subarraySums;
    }
}
