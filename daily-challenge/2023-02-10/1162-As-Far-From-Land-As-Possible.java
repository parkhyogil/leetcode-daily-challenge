class Solution {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(i * n + j);
                    grid[i][j] = -1;
                }
            }
        }

        if (q.size() == 0 || q.size() == n * n) {
            return -1;
        }

        int res = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();

                int r = cur / n;
                int c = cur % n;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (isOutOfBoundary(nr, nc, n) || grid[nr][nc] == -1) {
                        continue;
                    }

                    q.offer(nr * n + nc);
                    grid[nr][nc] = -1;
                }
            }
            res++;
        }
        return res;
    }

    private boolean isOutOfBoundary(int r, int c, int n) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}
