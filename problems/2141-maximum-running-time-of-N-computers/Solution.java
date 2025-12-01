class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long lo = 0, hi = (long) 1e9 * batteries.length / n;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (decide(n, mid, batteries)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    boolean decide(int n, long t, int[] arr) {
        long sum = 0;

        for (int v : arr) {
            sum += Math.min(v, t);
        }

        return sum >= n * t;
    }
}
