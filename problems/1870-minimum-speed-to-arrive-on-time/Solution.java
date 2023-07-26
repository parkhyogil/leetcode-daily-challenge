class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;

        if ((int) hour < n - 1) {
            return -1;
        }

        int lo = 1;
        int hi = 10000000;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canArrive(dist, hour, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canArrive(int[] dist, double hour, int speed) {
        int n = dist.length;

        double sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += (dist[i] + speed - 1) / speed;
            if (sum > hour) {
                return false;
            }
        }
        sum += (double) dist[n - 1] / speed;
        return sum <= hour;
    }
}
