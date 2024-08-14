class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;

        int lo = 0;
        int hi = nums[n - 1] - nums[0];

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (countDistanceLessThanOrEqual(nums, mid) >= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int countDistanceLessThanOrEqual(int[] nums, int target) {
        int result = 0;

        for (int left = 0, right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > target) {
                left++;
            }

            result += right - left;
        }

        return result;
    }
}
