class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < n; i++) {
            result = Math.min(result, nums[i + k - 1] - nums[i]);
        }

        return result;
    }
}
