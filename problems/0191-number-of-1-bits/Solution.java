public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        n = ((n >>> 1) & 0x55555555) + (n & 0x55555555);
        n = ((n >>> 2) & 0x33333333) + (n & 0x33333333);
        n = ((n >>> 4) & 0x0f0f0f0f) + (n & 0x0f0f0f0f);
        n = ((n >>> 8) & 0x00ff00ff) + (n & 0x00ff00ff);
        n = ((n >>> 16) & 0x0000ffff) + (n & 0x0000ffff);

        return n;
    }
}
