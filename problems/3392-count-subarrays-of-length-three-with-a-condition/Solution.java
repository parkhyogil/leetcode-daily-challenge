class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;

        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                result++;
            }
        }

        return result;
    }
}
