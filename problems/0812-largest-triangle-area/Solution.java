class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;

        double result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = getArea(points[i], points[j], points[k]);
                    if (area > result) {
                        result = area;
                    }
                }
            }
        }

        return result;
    }

    double getArea(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - (a[1] * b[0] + b[1] * c[0] + c[1] * a[0]));
    }
}
