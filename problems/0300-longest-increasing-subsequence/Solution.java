class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int idx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[idx]) {
                nums[++idx] = nums[i];
            } else {
                nums[binarySearch(nums, 0, idx, nums[i])] = nums[i];
            }
        }

        return idx + 1;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return lo;
        }

        int mid = (lo + hi) / 2;

        if (nums[mid] >= target) {
            return binarySearch(nums, lo, mid - 1, target);
        }
        return binarySearch(nums, mid + 1, hi, target);
    }
}
