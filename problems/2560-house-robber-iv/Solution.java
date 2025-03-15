class Solution {
    public int minCapability(int[] nums, int k) {
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;

        for (int num : nums) {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(mid, nums, k)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    boolean decide(int capability, int[] nums, int k) {
        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            if (num <= capability) {
                int curr = Math.max(prev2 + 1, prev1);
                prev2 = prev1;
                prev1 = curr;
            } else {
                prev1 = Math.max(prev1, prev2);
                prev2 = Math.max(prev1, prev2);
            }
        }

        return Math.max(prev1, prev2) >= k;
    }
}
