class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMin = 0;
        int curMax = 0;
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            curMin = Math.min(curMin, 0) + num;
            curMax = Math.max(curMax, 0) + num;

            minSum = Math.min(minSum, curMin);
            maxSum = Math.max(maxSum, curMax);

            sum += num;
        }

        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
