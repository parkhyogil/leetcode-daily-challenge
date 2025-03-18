class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;

        int maxLength = 0;
        int bits = 0;

        for (int l = 0, r = 0; r < n; r++) {
            while ((bits & nums[r]) != 0) {
                bits ^= nums[l++];
            }

            bits |= nums[r];

            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
