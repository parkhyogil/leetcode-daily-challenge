class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int numEmpty = numBottles;
        numBottles = 0;

        while (numEmpty >= numExchange) {
            numBottles = numEmpty / numExchange;
            numEmpty %= numExchange;

            res += numBottles;
            
            numEmpty += numBottles;
            numBottles = 0;
        }

        return res;
    }
}
