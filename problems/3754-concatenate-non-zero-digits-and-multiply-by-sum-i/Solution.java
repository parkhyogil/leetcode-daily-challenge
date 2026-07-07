class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;

        int i = 1;

        while (n > 0) {
            int d = n % 10;

            if (d > 0) {
                x += i * d;
                i *= 10;
                sum += d;
            }

            n /= 10;
        }

        return (long) x * sum;
    }
}
