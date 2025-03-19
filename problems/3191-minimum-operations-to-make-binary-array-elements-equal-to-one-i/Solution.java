class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                result++;
            }
        }

        return nums[n - 2] == 1 && nums[n - 1] == 1 ? result : -1;
    }
}
