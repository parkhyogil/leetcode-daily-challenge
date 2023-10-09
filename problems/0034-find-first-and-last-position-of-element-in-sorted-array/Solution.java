class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1) - 1;

        if (left > right) {
            return new int[] {-1, -1};
        }
        
        return new int[] {left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
