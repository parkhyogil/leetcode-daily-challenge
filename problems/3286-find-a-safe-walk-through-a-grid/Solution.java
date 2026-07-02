class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        if (grid.get(0).get(0) == 1) {
            health--;
        }

        if (health == 0) {
            return false;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, health});

        int[][] visit = new int[m][n];
        visit[0][0] = health;

        while (!queue.isEmpty()) {
            int[] i = queue.poll();

            int r = i[0], c = i[1], h = i[2];

            for (int[] d : new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr == m || nc < 0 || nc == n) {
                    continue;
                }

                int nh = h - (grid.get(nr).get(nc) == 1 ? 1 : 0);

                if (nh == 0 || visit[nr][nc] >= nh) {
                    continue;
                }

                queue.offer(new int[] {nr, nc, nh});
                visit[nr][nc] = nh;
            }
        }

        return visit[m - 1][n - 1] > 0;
    }
}
