class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 0; i < n; i++) {
            leftMax[i] = i > 0 ? Math.max(leftMax[i - 1], nums[i - 1]) : 0;
            rightMax[n - i - 1] = i > 0 ? Math.max(rightMax[n - i], nums[n - i]) : 0;
        }

        long result = 0L;

        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, (long) (leftMax[i] - nums[i]) * rightMax[i]);
        }

        return result;
    }
}
