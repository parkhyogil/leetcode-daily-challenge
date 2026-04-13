class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int result = n;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(start - i));
            }
        }

        return result;
    }
}
