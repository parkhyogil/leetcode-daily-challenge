class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += Math.abs(nums[i] - nums[n / 2]);
        }

        return result;
    }
}
