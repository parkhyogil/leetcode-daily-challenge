class Solution {
    public long repairCars(int[] ranks, int cars) {
        long lo = 1;
        long hi = (long) 1e14;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (decide(mid, ranks, cars)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    boolean decide(long time, int[] ranks, int cars) {
        for (int rank : ranks) {
            cars -= (int) Math.sqrt(time / rank);

            if (cars <= 0) {
                return true;
            }
        }

        return false;
    }
}
