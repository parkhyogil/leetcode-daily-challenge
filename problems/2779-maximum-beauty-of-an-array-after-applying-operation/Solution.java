class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int maxBeauty = 0;

        for (int l = 0, r = 0; r < n; r++) {
            while (nums[l] + k < nums[r] - k) {
                l++;
            }

            maxBeauty = Math.max(maxBeauty, r - l + 1);
        }

        return maxBeauty;
    }
}
