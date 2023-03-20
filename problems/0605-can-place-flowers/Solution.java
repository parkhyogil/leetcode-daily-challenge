class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;

        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0 && flowerbed[Math.max(i - 1, 0)] == 0 && flowerbed[Math.min(i + 1, m - 1)] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
