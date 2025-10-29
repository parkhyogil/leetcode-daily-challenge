class Solution {
    public int smallestNumber(int n) {
        int i = 0;
        while (n > 0) {
            n >>= 1;
            i++;
        }

        return (1 << i) - 1;
    }
}
