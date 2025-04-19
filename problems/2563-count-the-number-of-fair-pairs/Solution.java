class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;

        Arrays.sort(nums);

        long result = 0;

        for (int i = 0; i < n; i++) {
            int right = binarySearch(upper - nums[i] + 1, nums);

            if (right <= i) {
                break;
            }

            int left = binarySearch(lower - nums[i], nums);

            result += right - Math.max(i + 1, left);
        }

        return result;
    }

    private int binarySearch(int target, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
