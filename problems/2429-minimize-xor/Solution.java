class Solution {
    public int minimizeXor(int num1, int num2) {
        int diff = Integer.bitCount(num2) - Integer.bitCount(num1);

        if (diff == 0) {
            return num1;
        }

        int result = num1;

        if (diff > 0) {
            for (int i = 1; diff > 0; i *= 2) {
                if ((num1 & i) == 0) {
                    diff--;
                    result |= i;
                }
            }
        } else {
            for (int i = 1; diff < 0; i *= 2) {
                if ((num1 & i) > 0) {
                    diff++;
                    result ^= i;
                }
            }
        }
        return result;
    }
}
