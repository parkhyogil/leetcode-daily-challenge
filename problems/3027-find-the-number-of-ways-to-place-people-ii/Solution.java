class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int result = 0;

        for (int i = 0; i < n; i++) {
            int y0 = points[i][1];
            int minY = Integer.MIN_VALUE;

            for (int j = i + 1; j < n && y0 > minY; j++) {
                int y1 = points[j][1];

                if (y0 >= y1 && y1 > minY) {
                    result++;
                    minY = y1;
                }
            }
        }

        return result;
    }
}
