class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = 100;
        int min2 = 100;

        for (int price : prices) {
            if (price < min1) {
                min2 = min1;
                min1 = price;
            } else if (price < min2) {
                min2 = price;
            }
        }

        return min1 + min2 > money ? money : money - min1 - min2;
    }
}
