class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int f = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            f += nums[i] * i;
            sum += nums[i];
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            result = Math.max(result, f);
            f += nums[i] * n - sum;
        }

        return result;
    }
}
