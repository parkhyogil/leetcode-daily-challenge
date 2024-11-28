class Solution {
    private final int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> emptyCells = new ArrayDeque<>();
        Queue<int[]> obstacles = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        emptyCells.offer(new int[] {0, 0});
        visited[0][0] = true;

        int result = 0;

        while (!emptyCells.isEmpty()) {
            int size = emptyCells.size();

            while (size-- > 0) {
                int[] curr = emptyCells.poll();

                if (curr[0] == m - 1 && curr[1] == n - 1) {
                    return result;
                }

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if (isOutOfBoundary(nr, nc, m, n) || visited[nr][nc]) {
                        continue;
                    }

                    if (grid[nr][nc] == 0) {
                        emptyCells.offer(new int[] {nr, nc});
                    } else {
                        obstacles.offer(new int[] {nr, nc});
                    }
                    visited[nr][nc] = true;
                }
            }

            if (emptyCells.isEmpty()) {
                emptyCells.addAll(obstacles);
                obstacles.clear();
                result++;
            }
        }

        return result;
    }

    boolean isOutOfBoundary(int r, int c, int m, int n) {
        return r < 0 || r == m || c < 0 || c == n;
    }
}
