class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int res = n + 1;
        int sum = 0;

        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];

            while (sum >= target && l <= r) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res == n + 1 ? 0 : res;
    }
}
