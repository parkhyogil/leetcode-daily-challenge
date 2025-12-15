class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;

        long result = 0;

        for (int i = 0, j = -1; i < n; i++) {
            if (j == -1 || prices[i - 1] - prices[i] != 1) {
                j = i;
            }
            result += i - j + 1;
        }

        return result;
    }
}
