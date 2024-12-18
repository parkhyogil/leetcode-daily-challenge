class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        int[] stack = new int[n];
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int price = prices[i];

            while (idx > -1 && prices[stack[idx]] >= price) {
                prices[stack[idx--]] -= price;
            }
            stack[++idx] = i;
        }

        return prices;
    }
}
