class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long lo = 0;
        long hi = (long) 1e9 * batteries.length / n;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (canRun(n, batteries, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return hi;
    }

    private boolean canRun(int n, int[] batteries, long time) {
        long sum = 0;
        for (int bat : batteries) {
            sum += Math.min(bat, time);
        }
        return sum >= n * time;
    }
}
