class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (isNoZeroInt(i) && isNoZeroInt(n - i)) {
                return new int[] {i, n - i};
            }
        }

        return new int[0];
    }

    boolean isNoZeroInt(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }

        return true;
    }
}
