class Solution {
    public int smallestNumber(int n, int t) {
        while (n < 100) {
            int x = n;
            int p = 1;

            while (x > 0) {
                p *= x % 10;
                x /= 10;

                if (p % t == 0) {
                    return n;
                }
            }
            n++;
        }

        return n;
    }
}
