class Solution {
    public boolean checkDivisibility(int n) {
        int x = n;

        int s = 0;
        int p = 1;

        while (n > 0) {
            int d = n % 10;
            n /= 10;

            s += d;
            p *= d;
        }

        return x % (s + p) == 0;
    }
}
