class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        return Math.max(findUpperbound(-1, nums), n - findUpperbound(0, nums));
    }

    int findUpperbound(int target, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
