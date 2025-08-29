class Solution {
    public long flowerGame(int n, int m) {
        return (long) n / 2 * ((m + 1) / 2) + (long) m / 2 * ((n + 1) / 2);
    }
}
