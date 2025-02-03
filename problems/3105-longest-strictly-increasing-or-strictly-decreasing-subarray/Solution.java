class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int inc = 1;
        int dec = 1;

        int result = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                inc++;
                dec = 1;
                result = Math.max(result, inc);
            } else if (nums[i - 1] > nums[i]) {
                dec++;
                inc = 1;
                result = Math.max(result, dec);
            } else {
                inc = dec = 1;
            }
        }

        return result;
    }
}
