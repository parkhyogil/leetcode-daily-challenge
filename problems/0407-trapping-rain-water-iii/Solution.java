class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            queue.offer(new int[] {i, 0, heightMap[i][0]});
            queue.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {0, i, heightMap[0][i]});
            queue.offer(new int[] {m - 1, i, heightMap[m - 1][i]});
            visited[0][i] = visited[m - 1][i] = true;
        }

        int result = 0;

        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int r = a[0], c = a[1], h = a[2];

            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];

                if (isOutOfBoundary(nr, nc, heightMap) || visited[nr][nc]) {
                    continue;
                }

                int nh = heightMap[nr][nc];

                if (nh < h) {
                    result += h - nh;
                    nh = h;
                }

                queue.offer(new int[] {nr, nc, nh});
                visited[nr][nc] = true;
            }
        }

        return result;
    }

    boolean isOutOfBoundary(int r, int c, int[][] grid) {
        return r < 0 || c < 0 || r == grid.length || c == grid[0].length;
    }
}
