class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 1, j = 1; i <= n; i *= 2, j++) {
            for (int k = i; k < i * 2 && k <= n; k++) {
                result = ((result << j) + k) % mod;
            }
        }

        return (int) result;
    }
}
