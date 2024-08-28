class Solution {
    private int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        boolean[][] visit = new boolean[m][n];
        int numberOfSubIslands = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid2[r][c] == 1 && !visit[r][c] && isSubIsland(r, c, grid1, grid2, visit)) {
                    numberOfSubIslands++;
                }
            }
        }

        return numberOfSubIslands;
    }

    private boolean isSubIsland(int r, int c, int[][] grid1, int[][] grid2, boolean[][] visit) {
        boolean result = true;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            result &= grid1[curr[0]][curr[1]] == 1;

            for (int[] d : dir) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr < 0 || nc < 0 || nr == grid1.length || nc == grid1[0].length || grid2[nr][nc] == 0 || visit[nr][nc]) {
                    continue;
                }

                queue.offer(new int[] {nr, nc});
                visit[nr][nc] = true;
            }
        }

        return result;
    }
}
