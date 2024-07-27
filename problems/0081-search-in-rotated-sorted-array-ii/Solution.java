class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        return binarySearch(0, n - 1, nums, target);
    }

    private boolean binarySearch(int left, int right, int[] nums, int target) {
        if (left > right) {
            return false;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return true;
        }

        while (left < mid && nums[left] == nums[mid]) {
            left++;
        }

        if ((nums[left] <= target && (target < nums[mid] || nums[mid] < nums[left])) || (target < nums[mid] && nums[mid] < nums[left])) {
            return binarySearch(left, mid - 1, nums, target);
        }
        return binarySearch(mid + 1, right, nums, target);
    }
}
