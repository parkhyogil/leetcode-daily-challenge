class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int diff = recur(0, stoneValue, new Integer[n]);
        return diff == 0 ? "Tie" : diff > 0 ? "Alice" : "Bob";
    }

    private int recur(int idx, int[] nums, Integer[] memo) {
        if (idx >= nums.length) {
            return 0;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 3 && idx + i < nums.length; i++) {
            sum += nums[idx + i];
            res = Math.max(res, sum - recur(idx + i + 1, nums, memo));
        }
        return memo[idx] = res;
    }
}
