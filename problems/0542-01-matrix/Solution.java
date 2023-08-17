class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Integer> q = new LinkedList<>();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(i * n + j);
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int curr = q.poll();
                int r = curr / n;
                int c = curr % n;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || dp[nr][nc] != -1) {
                        continue;
                    }

                    dp[nr][nc] = dp[r][c] + 1;
                    q.offer(nr * n + nc);
                }
            }
        }

        return dp;
    }
}
