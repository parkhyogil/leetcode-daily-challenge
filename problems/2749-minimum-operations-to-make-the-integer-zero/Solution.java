class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        long n1 = num1;

        for (int i = 1; n1 > num2; i++) {
            n1 -= num2;

            if (Long.bitCount(n1) <= i && n1 >= i) {
                return i;
            }
        }

        return -1;
    }
}
