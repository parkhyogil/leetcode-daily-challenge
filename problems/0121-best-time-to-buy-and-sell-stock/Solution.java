class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int res = 0;

        for (int price : prices) {
            if (buy > price) {
                buy = price;
            } else {
                res = Math.max(res, price - buy);
            }
        }
        return res;
    }
}
