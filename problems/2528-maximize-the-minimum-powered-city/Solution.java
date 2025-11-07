class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long low = 0, high = (100000L + k / n) * n;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (decide(n, r, k, mid, stations)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    boolean decide(int n, int r, int k, long min, int[] stations) {
        long power = 0;

        int[] d = new int[n];

        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && j - i <= r) {
                power += stations[j++];
            }

            if (i - r - 1 >= 0) {
                power -= stations[i - r - 1] + d[i - r - 1];
            }

            if (power < min) {
                if (min - power > k) {
                    return false;
                }

                d[j - 1] = (int) (min - power);
                power += d[j - 1];
                k -= d[j - 1];
            }
        }

        return true;
    }
}
