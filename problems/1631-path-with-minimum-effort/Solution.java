class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visit = new boolean[m][n];

        pq.offer(new int[] {0, 0, 0});

        int res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];

            visit[r][c] = true;

            res = Math.max(res, curr[2]);

            if (r == m - 1 && c == n - 1) {
                return res;
            }

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr == m || nc == n || visit[nr][nc]) {
                    continue;
                }

                pq.offer(new int[] {nr, nc, Math.abs(heights[nr][nc] - heights[r][c])});
            }
        }
        return -1;
    }
}
