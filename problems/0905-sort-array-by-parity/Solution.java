class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;

        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                int num = nums[i];
                nums[i] = nums[j];
                nums[j] = num;
                j++;
            }
        }

        return nums;
    }
}
