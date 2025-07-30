class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int max = 0;
        int result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            if (nums[l] != nums[r]) {
                l = r;
            }

            if (nums[r] > max) {
                max = nums[r];
                result = 1;
            } else if (nums[r] == max) {
                result = Math.max(result, r - l + 1);
            }
        }

        return result;
    }
}
