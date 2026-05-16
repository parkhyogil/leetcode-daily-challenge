class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }

        return nums[lo];
    }
}
