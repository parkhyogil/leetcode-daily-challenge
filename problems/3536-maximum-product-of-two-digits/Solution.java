class Solution {
    public int maxProduct(int n) {
        int a = 0;
        int b = 0;

        while (n > 0) {
            int d = n % 10;
            n /= 10;

            if (d > a) {
                b = a;
                a = d;
            } else if (d > b) {
                b = d;
            }
        }

        return a * b;
    }
}
