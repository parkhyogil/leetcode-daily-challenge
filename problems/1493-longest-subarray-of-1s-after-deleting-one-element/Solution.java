class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int result = 0;
        boolean containsZero = false;

        for (int l = 0, r = 0; r < n; r++) {
            while (nums[r] == 0 && containsZero) {
                if (nums[l++] == 0) {
                    containsZero = false;
                }
            }

            if (nums[r] == 0) {
                containsZero = true;
            }

            result = Math.max(result, r - l);
        }

        return result;
    }
}
