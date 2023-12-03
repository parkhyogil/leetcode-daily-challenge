class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += getTime(points[i], points[i + 1]);
        }
        return res;
    }

    private int getTime(int[] p1, int[] p2) {
        int w = Math.abs(p1[0] - p2[0]);
        int h = Math.abs(p1[1] - p2[1]);

        return Math.max(w, h);        
    }
}
