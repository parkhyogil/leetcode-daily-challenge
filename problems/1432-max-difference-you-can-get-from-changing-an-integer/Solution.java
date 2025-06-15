class Solution {
    public int maxDiff(int num) {
        int x = num;

        int leftmostDigit = num / (int) Math.pow(10, (int) Math.log10(num));

        int toZero = -1;
        int toOne = -1;
        int toNine = -1;

        while (x > 0) {
            int d = x % 10;
            x /= 10;

            if (d < 9) {
                toNine = d;
            }
            if (d > 1) {
                toOne = d;
            }
            if (d != leftmostDigit && d > 0) {
                toZero = d;
            }
        }

        int result = 0;

        for (int i = 1; num > 0; i *= 10) {
            int d = num % 10;
            num /= 10;

            result += (d == toNine ? 9 : d) * i;
            result -= (leftmostDigit == 1 ? (d == toZero ? 0 : d) : (d == toOne ? 1 : d)) * i;
        }

        return result;
    }
}
