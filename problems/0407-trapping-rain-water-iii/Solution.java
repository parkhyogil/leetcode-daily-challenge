class Solution {
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            priorityQueue.offer(new int[] {i, 0, heightMap[i][0]});
            priorityQueue.offer(new int[] {i, n - 1, heightMap[i][n - 1]});

            visited[i][0] = visited[i][n - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new int[] {0, i, heightMap[0][i]});
            priorityQueue.offer(new int[] {m - 1, i, heightMap[m - 1][i]});

            visited[0][i] = visited[m - 1][i] = true;
        }

        int result = 0;

        while (!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.poll();
            int row = curr[0];
            int col = curr[1];
            int height = curr[2];

            for (int[] d : dir) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (isOutOfBoundary(nextRow, nextCol, heightMap) || visited[nextRow][nextCol]) {
                    continue;
                }

                int nextHeight = heightMap[nextRow][nextCol];

                if (nextHeight < height) {
                    result += height - heightMap[nextRow][nextCol];
                    nextHeight = height;
                }

                priorityQueue.offer(new int[] {nextRow, nextCol, nextHeight});
                visited[nextRow][nextCol] = true;
            }
        }

        return result;
    }

    private boolean isOutOfBoundary(int row, int col, int[][] grid) {
        return row < 0 || col < 0 || row == grid.length || col == grid[0].length;
    }
}
