class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0;
        long hi = Long.MAX_VALUE;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (decide(mid, time, totalTrips)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean decide(long time, int[] nums, int totalTrips) {
        long count = 0;
        for (int num : nums) {
            count += time / num;
            if (count >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
