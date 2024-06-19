class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length / k < m) {
            return -1;
        }

        int lo = Integer.MAX_VALUE;
        int hi = 0;

        for (int day : bloomDay) {
            lo = Math.min(lo, day);
            hi = Math.max(hi, day);
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canMake(mid, bloomDay, m, k)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canMake(int maxDay, int[] bloomDay, int m, int k) {
        int count = 0;

        for (int day : bloomDay) {
            if (day <= maxDay) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                m--;
                count = 0;
            }
        }   

        return m <= 0;
    }
}
