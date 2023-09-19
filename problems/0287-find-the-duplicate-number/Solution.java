class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int lo = 1;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (count(mid, nums) <= n - 1 - mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int count(int target, int[] nums) {
        int res = 0;

        for (int num : nums) {
            if (num > target) {
                res++;
            }
        }
        return res;
    }
}
