class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result * 2 + n % 2;
            n /= 2;
        }

        return result;
    }
}
