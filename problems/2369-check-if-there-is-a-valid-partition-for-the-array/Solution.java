class Solution {
    private int n;
    private int[] nums;
    private Boolean[] memo;

    public boolean validPartition(int[] nums) {
        n = nums.length;
        this.nums = nums;
        memo = new Boolean[n];

        return recur(0);
    }

    private boolean recur(int idx) {
        if (idx == n) {
            return true;
        }
        
        if (memo[idx] != null) {
            return memo[idx];
        }

        boolean res = false;

        if (idx + 1 < n && nums[idx] == nums[idx + 1]) {
            res |= recur(idx + 2);
        }

        if (idx + 2 < n && ((nums[idx] == nums[idx + 1] && nums[idx] == nums[idx + 2]) || (nums[idx] == nums[idx + 1] - 1 && nums[idx] == nums[idx + 2] - 2))) {
            res |= recur(idx + 3);
        }

        return memo[idx] = res;
    }
}
