class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOrValue = 0;

        for (int num : nums) {
            maxOrValue |= num;
        }

        return combination(0, 0, maxOrValue, nums);
    }

    private int combination(int idx, int value, int maxOrValue, int[] nums) {
        if (value == maxOrValue) {
            return 1 << (nums.length - idx);
        }

        int result = 0;

        for (int i = idx; i < nums.length; i++) {
            result += combination(i + 1, value | nums[i], maxOrValue, nums);
        }

        return result;
    }
}
