class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;

        int maxNum = (1 << maximumBit) - 1;

        int totalXor = 0;
        for (int num : nums) {
            totalXor ^= num;
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = maxNum ^ totalXor;
            totalXor ^= nums[n - 1 - i];
        }

        return result;
    }
}
