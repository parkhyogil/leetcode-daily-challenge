class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        for (int i = 0, j = -1; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }

            if (nums[i] != 0) {
                int num = nums[i];
                nums[i] = 0;
                nums[++j] = num;
            }
        }

        return nums;
    }
}
