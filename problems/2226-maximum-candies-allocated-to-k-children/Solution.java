class Solution {
    public int maximumCandies(int[] candies, long k) {
        int lo = 1;
        int hi = 10000000;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(mid, candies, k)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    boolean decide(int size, int[] candies, long k) {
        for (int candy : candies) {
            k -= candy / size;
        }

        return k <= 0;
    }
}
