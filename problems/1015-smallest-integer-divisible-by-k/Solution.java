class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int x = k;
        int result = 0;

        while (x > 0) {
            while (x % 10 != 1) {
                x += k;
            }

            result++;
            x /= 10;
        }

        return result;
    }
}
