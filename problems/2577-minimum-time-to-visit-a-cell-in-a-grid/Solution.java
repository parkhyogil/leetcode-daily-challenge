class Solution {
    private final int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] + 1 < grid[0][1] && grid[0][0] + 1 < grid[1][0]) {
            return -1;
        }

        int[][] time = new int[m][n];
        for (int[] arr : time) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[] {0, 0, 0});
        time[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            if (r == m - 1 && c == n - 1) {
                return t;
            }

            if (t > time[r][c]) {
                continue;
            }

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (isOutOfBoundary(nr, nc, m, n) || t + 1 >= time[nr][nc]) {
                    continue;
                }

                int nextTime = t + 1 + (Math.max(grid[nr][nc], t) - t) / 2 * 2;
                time[nr][nc] = nextTime;
                queue.offer(new int[] {nr, nc, nextTime});
            }
        }

        return -1;
    }

    boolean isOutOfBoundary(int r, int c, int m, int n) {
        return r < 0 || r == m || c < 0 || c == n;
    }
}
