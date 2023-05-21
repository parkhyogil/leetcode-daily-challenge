class Solution {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int n;
    private int[][] grid;
    private Queue<Integer> q;

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                dfs(i, j);
                return bfs();
            }
        }
        return -1;
    }

    private int bfs() {
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int cur = q.poll();
                int r = cur / n;
                int c = cur % n;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];

                    if (isOutOfBoundary(nr, nc) || grid[nr][nc] == -1) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        return res;
                    }
                    grid[nr][nc] = -1;
                    q.offer(nr * n + nc);
                }
            }
            res++;
        }
        return res;
    }

    private void dfs(int r, int c) {
        if (isOutOfBoundary(r, c) || grid[r][c] != 1) {
            return;
        }       
        grid[r][c] = -1;
        q.offer(r * n + c);
        for (int i = 0; i < 4; i++) {
            dfs(r + dir[i][0], c + dir[i][1]);
        }
    }

    private boolean isOutOfBoundary(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}
