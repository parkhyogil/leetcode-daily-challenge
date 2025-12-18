class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] prefix0 = new long[n + 1];
        long[] prefix1 = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix0[i + 1] = prefix0[i] + prices[i] * strategy[i];
            prefix1[i + 1] = prefix1[i] + prices[i];
        }

        long total = prefix0[n];
        long result = total;

        for (int i = 0; i + k <= n; i++) {
            result = Math.max(result, total - query(i, i + k - 1, prefix0) + query(i + k / 2, i + k - 1, prefix1));
        }

        return result;
    }

    long query(int l, int r, long[] prefix) {
        return prefix[r + 1] - prefix[l];
    }
}
