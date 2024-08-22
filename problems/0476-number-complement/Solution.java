class Solution {
    public int findComplement(int num) {
        int bit = 1;
        int result = 0;

        while (num > 0) {
            if ((num & 1) == 0) {
                result |= bit;
            }

            bit *= 2;
            num /= 2;
        }

        return result;
    }
}
