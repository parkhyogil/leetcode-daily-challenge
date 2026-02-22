class Solution {
    public int binaryGap(int n) {
        int result = 0;

        int prev = -1;
        int i = 0;

        while (n > 0) {
            int bit = n % 2;
            n /= 2;

            if (bit == 1) {
                if (prev != -1) {
                    result = Math.max(result, i - prev);
                }
                prev = i;
            }
            i++;
        }

        return result;
    }
}
