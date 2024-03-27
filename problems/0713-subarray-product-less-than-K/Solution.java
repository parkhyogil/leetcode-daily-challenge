class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int n = nums.length;

        int res = 0;
        int product = 1;

        for (int l = 0, r = 0; r < n; r++) {
            product *= nums[r];

            while (product >= k) {
                product /= nums[l++];
            }

            res += r - l + 1;
        }

        return res;
    }
}
