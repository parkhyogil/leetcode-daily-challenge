class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int result = 0;
        int sum = 0;

        for (int l = 0, r = 0; r < fruits.length; r++) {
            sum += fruits[r][1];

            while (l <= r && countStep(fruits[l][0], fruits[r][0], startPos) > k) {
                sum -= fruits[l++][1];
            }

            result = Math.max(result, sum);
        }

        return result;
    }

    int countStep(int l, int r, int start) {
        return Math.min(Math.abs(start - l), Math.abs(start - r)) + r - l;
    }
}
