class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int length = (1 << n) - 1;

        int mid = (1 + length) / 2;

        if (k == mid) {
            return '1';
        }

        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        return invert(findKthBit(n - 1, length - k + 1));
    }

    private char invert(char c) {
        return c == '0' ? '1' : '0';
    }
}
