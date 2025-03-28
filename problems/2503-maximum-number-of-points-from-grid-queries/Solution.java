class Solution {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;

        int  maxQueryValue = 0;
        for (int query : queries) {
            maxQueryValue = Math.max(maxQueryValue, query);
        }

        int[] points = new int[maxQueryValue + 1];

        calculatePoints(grid, points);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = points[queries[i]];
        }

        return result;
    }

    private void calculatePoints(int[][] grid, int[] points) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[] {0, 0, grid[0][0]});

        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;

        int point = 0;
        int prev = 0;

        while (!queue.isEmpty() && prev < points.length) {
            while (prev <= queue.peek()[2] && prev < points.length) {
                points[prev++] = point;
            }

            while (!queue.isEmpty() && queue.peek()[2] < prev) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                point++;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr == m || nc < 0 || nc == n || visit[nr][nc]) {
                        continue;
                    }

                    queue.offer(new int[] {nr, nc, grid[nr][nc]});
                    visit[nr][nc] = true;
                }
            }
        }

        for (int i = prev; i < points.length; i++) {
            points[i] = point;
        }
    }
}
