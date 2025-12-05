class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        for (int num : nums) {
            right += num;
        }

        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            right -= nums[i];

            if ((right - left) % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}
