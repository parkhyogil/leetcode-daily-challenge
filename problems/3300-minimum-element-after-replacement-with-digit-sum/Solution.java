class Solution {
    public int minElement(int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int x : nums) {
            result = Math.min(getDigitSum(x), result);
        }

        return result;
    }

    int getDigitSum(int x) {
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}
