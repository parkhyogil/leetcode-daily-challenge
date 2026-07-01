class Solution {
    int n;
    int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] minDist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[] {i, j});
                    minDist[i][j] = 0;
                } else {
                    minDist[i][j] = -1;
                }
            }
        }


        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int[] d : dir) {
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];

                    if (nr < 0 || nr == n || nc < 0 || nc == n || minDist[nr][nc] > -1) {
                        continue;
                    }

                    queue.offer(new int[] {nr, nc});
                    minDist[nr][nc] = minDist[cur[0]][cur[1]] + 1;
                }
            }
        }

        int lo = 0;
        int hi = n;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(mid, minDist)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    boolean decide(int min, int[][] minDist) {
        if (minDist[0][0] < min) {
            return false;
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});

        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nr == n || nc < 0 || nc == n || visit[nr][nc] || minDist[nr][nc] < min) {
                    continue;
                }

                queue.offer(new int[] {nr, nc});
                visit[nr][nc] = true;
            }
        }

        return visit[n - 1][n - 1];
    }
}
