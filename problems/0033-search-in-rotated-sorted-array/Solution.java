class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int x = nums[mid];

            if (x == target) {
                return mid;
            }

            if (nums[lo] <= x) {
                if (nums[lo] <= target && target < x) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (x < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
