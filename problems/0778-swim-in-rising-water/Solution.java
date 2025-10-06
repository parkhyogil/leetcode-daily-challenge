class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[] {0, 0, grid[0][0]});
        visited[0][0] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], e = curr[2];

            result = Math.max(result, e);

            if (r == n - 1 && c == n - 1) {
                return result;
            }

            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];

                if (nr < 0 || nc < 0 || nr == n || nc == n || visited[nr][nc]) {
                    continue;
                }

                queue.offer(new int[] {nr, nc, grid[nr][nc]});
                visited[nr][nc] = true;
            }
        }

        return -1;
    }
}
