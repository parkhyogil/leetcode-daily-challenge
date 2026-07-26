class Solution {
    public int maximumProduct(int[] nums) {
        int a, b, c, d, e;
        a = b = c = Integer.MIN_VALUE;
        d = e = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x > a) {
                c = b;
                b = a;
                a = x;
            } else if (x > b) {
                c = b;
                b = x;
            } else if (x > c) {
                c = x;
            }

            if (x < d) {
                e = d;
                d = x;
            } else if (x < e) {
                e = x;
            }
        }

        return Math.max(a * b * c, d * e * a);
    }
}
