class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (1 <= num && num <= n && num != nums[num - 1]) {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
                num = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
