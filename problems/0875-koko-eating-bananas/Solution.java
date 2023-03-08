class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1000000000;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(mid, piles, h)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean decide(int k, int[] piles, int h) {
        for (int p : piles) {
            h -= (p + k - 1) / k;
            if (h < 0) {
                return false;
            }
        }
        return true;
    }
}
