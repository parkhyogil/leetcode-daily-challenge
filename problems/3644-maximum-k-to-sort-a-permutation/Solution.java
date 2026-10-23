class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                result &= nums[i];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
