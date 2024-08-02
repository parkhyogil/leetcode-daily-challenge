class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int totalNumberOfOnes = 0;

        for (int num : nums) {
            totalNumberOfOnes += num;
        }

        int currNumberOfOnes = 0;

        for (int i = 0; i < totalNumberOfOnes; i++) {
            currNumberOfOnes += nums[i];
        }

        int res = totalNumberOfOnes - currNumberOfOnes;

        for (int r = totalNumberOfOnes; r < n + totalNumberOfOnes; r++) {
            currNumberOfOnes += nums[r % n] - nums[r - totalNumberOfOnes];

            res = Math.min(res, totalNumberOfOnes - currNumberOfOnes);
        }

        return res;
    }
}
