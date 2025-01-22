class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] heightMap = new int[m][n];
        int height = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] pos = queue.poll();

                for (int[] d : dir) {
                    int nr = pos[0] + d[0];
                    int nc = pos[1] + d[1];

                    if (isOutOfBoundary(nr, nc, m, n) || isWater[nr][nc] == 1 || heightMap[nr][nc] > 0) {
                        continue;
                    }

                    heightMap[nr][nc] = height;
                    queue.offer(new int[] {nr, nc});
                }
            }

            height++;
        }

        return heightMap;
    }

    boolean isOutOfBoundary(int r, int c, int m, int n) {
        return r < 0 || c < 0 || r == m || c == n;
    }
}
