class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;

        int lo = 0;
        int hi = maxSum;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canConstruct(n, index, maxSum, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi + 1;
    }

    private boolean canConstruct(int n, int index, int sum, int max) {
        return getSum(Math.max(0, max - index), max) + getSum(Math.max(0, max - (n - 1 - index)), max) - max <= sum;
    }

    private long getSum(int n, int m) {
        return (long) (n + m) * (m - n + 1) / 2;
    }
}
