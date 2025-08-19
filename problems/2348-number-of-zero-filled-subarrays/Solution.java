class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;

        long result = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result += ++zeroCount;
            } else {
                zeroCount = 0;
            }
        }

        return result;
    }
}
