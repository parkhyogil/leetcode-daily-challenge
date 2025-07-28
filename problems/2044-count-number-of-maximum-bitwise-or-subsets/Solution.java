class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;

        for (int num : nums) {
            target |= num;
        }

        return recur(0, 0, target, nums);
    }

    int recur(int i, int val, int target, int[] nums) {
        if (i == nums.length) {
            return val == target ? 1 : 0;
        }

        return recur(i + 1, val | nums[i], target, nums) + recur(i + 1, val, target, nums);
    }
}

