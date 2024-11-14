class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 1;
        int hi = 100000;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(mid, n, quantities)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    boolean decide(int amount, int n, int[] quantities) {
        int num = 0;

        for (int quantity : quantities) {
            num += (quantity + amount - 1) / amount;
        }

        return num <= n;
    }
}
