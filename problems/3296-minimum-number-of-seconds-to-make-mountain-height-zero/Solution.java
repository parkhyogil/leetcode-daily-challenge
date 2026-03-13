class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long lo = 1;
        long hi = (long) mountainHeight * (mountainHeight + 1) / 2 * 1000000;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (mountainHeight <= getHeight(mid, workerTimes)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    long getHeight(long t, int[] arr) {
        long result = 0;

        for (int num : arr) {
            result += ((long) Math.sqrt(8 * (t / num) + 1) - 1) / 2;
        }

        return result;
    }
}
