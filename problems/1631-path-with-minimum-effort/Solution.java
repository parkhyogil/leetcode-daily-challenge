class Solution {
    private int m;
    private int n;
    private int[][] heights;

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;

        int lo = 0;
        int hi = (int) 1e6;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canTravel(0, 0, mid, new boolean[m][n])) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canTravel(int r, int c, int max, boolean[][] visit) {
        if (r == m - 1 && c == n - 1) {
            return true;
        }

        boolean res = false;
        int h = heights[r][c];
        visit[r][c] = true;

        if (r > 0 && !visit[r - 1][c] && Math.abs(h - heights[r - 1][c]) <= max) {
            res |= canTravel(r - 1, c, max, visit);
        }
        if (r < m - 1 && !visit[r + 1][c] && Math.abs(h - heights[r + 1][c]) <= max) {
            res |= canTravel(r + 1, c, max, visit);
        }
        if (c > 0 && !visit[r][c - 1] && Math.abs(h - heights[r][c - 1]) <= max) {
            res |= canTravel(r, c - 1, max, visit);
        }
        if (c < n - 1 && !visit[r][c + 1] && Math.abs(h - heights[r][c + 1]) <= max) {
            res |= canTravel(r, c + 1, max, visit);
        }

        return res;
    }
}
