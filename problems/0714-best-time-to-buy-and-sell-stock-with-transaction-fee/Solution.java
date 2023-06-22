class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < n; i++) {
            int tmp = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, tmp + prices[i] - fee);
        }
        return sell;
    }
}
