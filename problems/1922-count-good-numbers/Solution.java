class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        return (int) (pow(5, (n + 1) / 2) * pow(4, n / 2) % MOD);
    }

    private long pow(long base, long exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        return pow(base * base % MOD, exponent / 2) * pow(base, exponent % 2) % MOD;
    }
}
