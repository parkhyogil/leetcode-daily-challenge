class Solution {
    public long countCommas(long n) {
        long result = 0;

        for (long i = 1000; i - 1 < n; i *= 1000) {
            result += n - i + 1;
        }

        return result;
    }
}
