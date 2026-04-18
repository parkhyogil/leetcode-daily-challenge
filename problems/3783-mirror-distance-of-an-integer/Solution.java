class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    int reverse(int n) {
        int result = 0;

        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }

        return result;
    }
}
