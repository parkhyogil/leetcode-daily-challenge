class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        return binarySearch(0, n - 1, nums, target);
    }

    private int binarySearch(int lo, int hi, int[] nums, int target) {
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if ((nums[lo] <= target && target < nums[mid]) || (nums[mid] < nums[lo] && nums[lo] <= target) || (target < nums[mid] && nums[mid] < nums[lo])) {
            return binarySearch(lo, mid - 1, nums, target);
        }
        return binarySearch(mid + 1, hi, nums, target);
    }
}
