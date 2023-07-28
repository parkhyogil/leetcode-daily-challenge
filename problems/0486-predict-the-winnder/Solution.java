class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return recur(0, n - 1, nums, new Integer[n][n]) >= 0;
    }

    private int recur(int left, int right, int[] nums, Integer[][] memo) {
        if (left == right) {
            return nums[left];
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        return memo[left][right] = Math.max(nums[left] - recur(left + 1, right, nums, memo), 
                                          nums[right] - recur(left, right - 1, nums, memo));
    }
}
