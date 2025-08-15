class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (1 << 30) % n == 0 && (0x2AAAAAAA & n) == 0;
    }
}
