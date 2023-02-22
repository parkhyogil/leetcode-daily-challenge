class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 1;
        int hi = 500 * weights.length / days;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canShip(mid, weights, days)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canShip(int capacity, int[] weights, int days) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
            if (sum > capacity) {
                sum = w;
                days--;
                if (w > capacity || days == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
