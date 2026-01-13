class Solution {
    public double separateSquares(int[][] squares) {
        double lo = Integer.MAX_VALUE;
        double hi = 0;

        for (int[] s : squares) {
            lo = Math.min(lo, s[1]);
            hi = Math.max(hi, s[1] + s[2]);
        }

        while (hi - lo > 1e-5) {
            double mid = (lo + hi) / 2;

            if (decide(mid, squares)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    boolean decide(double line, int[][] squares) {
        double area = 0;

        for (int[] s : squares) {
            int x = s[0], y = s[1], l = s[2];

            if (y + l <= line) {
                area += (double) l * l;
            } else if (y >= line) {
                area -= (double) l * l;
            } else {
                area += (line - y) * l - (y + l - line) * l;
            }
        }

        return area < 0;
    }
}
