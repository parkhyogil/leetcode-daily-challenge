class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int result = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[i] + sum) {
                sum = 0;
            }
            sum += nums[i];

            result = Math.max(result, sum);
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[i] + sum) {
                sum = 0;
            }
            sum += nums[i];

            result = Math.max(result, Math.abs(sum));
        }

        return result;
    }
}
