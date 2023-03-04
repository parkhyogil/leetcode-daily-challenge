class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;

        int minIdx = -1;
        int maxIdx = -1;
        int leftIdx = -1;

        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftIdx = i;
            }
            if (nums[i] == minK) {
                minIdx = i;
            }
            if (nums[i] == maxK) {
                maxIdx = i;
            }

            res += Math.max(0, Math.min(minIdx, maxIdx) - leftIdx);
        }
        return res;
    }
}
