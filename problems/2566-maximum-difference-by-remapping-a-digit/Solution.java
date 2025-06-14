class Solution {
    public int minMaxDifference(int num) {
        int x = num;

        int toNine = 0;
        int toZero = 0;

        while (x > 0) {
            int d = x % 10;
            x /= 10;

            if (d != 9) {
                toNine = d;
            }
            toZero = d;
        }

        int max = 0;
        int min = 0;

        for (int i = 1; num > 0; i *= 10) {
            int d = num % 10;
            num /= 10;

            if (d == toNine) {
                max += 9 * i;
            } else {
                max += d * i;
            }

            if (d != toZero) {
                min += d * i;
            }
        }

        return max - min;
    }
}
