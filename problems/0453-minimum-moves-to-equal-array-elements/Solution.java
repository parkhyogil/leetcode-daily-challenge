class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += nums[i] - nums[0];
        }

        return result;
    }
}
