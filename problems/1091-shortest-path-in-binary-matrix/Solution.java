class Solution {
    private final int[][] dir = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        Queue<Integer> q = new LinkedList<>();
        if (grid[0][0] == 0) {
            q.offer(0);
            grid[0][0] = 1;
        }

        int res = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                int r = cur / n;
                int c = cur % n;

                if (r == n - 1 && c == n - 1) {
                    return res;
                }

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (isOutOfBoundary(nr, nc, n) || grid[nr][nc] == 1) {
                        continue;
                    }
                    q.offer(nr * n + nc);
                    grid[nr][nc] = 1;
                }
            }
            res++;
        }   
        return -1;
    }

    private boolean isOutOfBoundary(int r, int c, int n) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}
