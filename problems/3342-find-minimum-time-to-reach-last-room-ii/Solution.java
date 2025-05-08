class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[n][m];

        queue.offer(new int[] {0, 0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int t = current[2];
            int x = current[3];

            if (r == n - 1 && c == m - 1) {
                return t;
            }

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr == n || nc < 0 || nc == m || visited[nr][nc]) {
                    continue;
                }

                queue.offer(new int[] {nr, nc, 1 + x + Math.max(t, moveTime[nr][nc]), x ^ 1});
                visited[nr][nc] = true;
            }
        }

        return -1;
    }
}
