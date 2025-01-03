class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long sum = 0;
        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];

            if (sum * 2 >= totalSum) {
                result++;
            }
        }

        return result;
    }
}
