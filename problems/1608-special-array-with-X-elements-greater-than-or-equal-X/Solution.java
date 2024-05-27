class Solution {
    public int specialArray(int[] nums) {
        int lo = 1;
        int hi = nums.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int c = count(nums, mid);

            if (c == mid) {
                return mid;
            }

            if (c < mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private int count(int[] nums, int target) {
        int res = 0;

        for (int num : nums) {
            if (num >= target) {
                res++;
            }
        }

        return res;
    }
}
