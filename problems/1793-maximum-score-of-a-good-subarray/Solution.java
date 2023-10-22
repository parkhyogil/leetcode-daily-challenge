class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;

        int min = nums[k];
        int left = k;
        int right = k;

        int res = min;

        while (left > 0 || right + 1 < n) {
            if (left == 0) {
                right++;
            } else if (right == n - 1) {
                left--;
            } else if (nums[left - 1] > nums[right + 1]) {
                left--;
            } else {
                right++;
            }

            min = Math.min(min, Math.min(nums[left], nums[right]));
            res = Math.max(res, min * (right - left + 1));
        }
        return res;
    }
}
