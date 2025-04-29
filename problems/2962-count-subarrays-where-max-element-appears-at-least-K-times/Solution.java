class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        int maxElement = 0;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        int count = 0;
        long result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] == maxElement) {
                count++;
            }

            while (count >= k) {
                result += n - r;

                if (nums[l++] == maxElement) {
                    count--;
                }
            }
        }

        return result;
    }
}
