class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = -1;
        int max = -1;

        for (int i = 0; i < n; i++) {
            if (min == -1 || nums[i] < nums[min]) {
                min = i;
            }
            if (max == -1 || nums[i] > nums[max]) {
                max = i;
            }
        }

        int l = Math.min(min, max);
        int r = Math.max(min, max);

        return Math.min(r + 1, Math.min(n - l, l + 1 + n - r));
    }
}
