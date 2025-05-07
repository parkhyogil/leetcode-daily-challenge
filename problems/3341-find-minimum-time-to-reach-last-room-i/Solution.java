class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int n = moveTime.length;
        int m = moveTime[0].length;

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
         
        visited[0][0] = true;
        queue.offer(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int t = current[2];

            if (r == n - 1 && c == m - 1) {
                return t;
            }

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (isOutOfBoundary(nr, nc, n, m) || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, 1 + Math.max(t, moveTime[nr][nc])});
            }
        }

        return -1;
    }

    private boolean isOutOfBoundary(int r, int c, int n, int m) {
        return r < 0 || r == n || c < 0 || c == m;
    }
}
