class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        int res = n + 1;
        int sum = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];

            while (sum > target) {
                sum -= nums[l++];
            }

            if (sum == target) {
                res = Math.min(res, n - (r - l + 1));
            }
        }
        return res > n ? -1 : res;
    }
}
