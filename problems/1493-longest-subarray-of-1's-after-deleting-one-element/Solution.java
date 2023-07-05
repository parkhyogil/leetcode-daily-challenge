class Solution {
    public int longestSubarray(int[] nums) {
        int prevZero = -1;
        int currZero = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                prevZero = currZero;
                currZero = i;
            }

            res = Math.max(res, i - (prevZero + 1));
        }
        return res;
    }
}
