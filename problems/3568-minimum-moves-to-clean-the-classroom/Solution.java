class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        char[][] grid = new char[m][];
        for (int i = 0; i < m; i++) {
            grid[i] = classroom[i].toCharArray();
        }

        int r = 0;
        int c = 0;
        int k = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    r = i;
                    c = j;
                } else if (grid[i][j] == 'L') {
                    grid[i][j] = (char) k;
                    k++;
                }
            }
        }

        int end = (1 << k) - 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c, energy, 0});

        boolean[][][][] visit = new boolean[m][n][energy + 1][end + 1];
        visit[r][c][energy][0] = true;

        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                r = cur[0];
                c = cur[1];
                int e = cur[2];
                int l = cur[3];

                if (l == end) {
                    return result;
                }

                if (e == 0) {
                    continue;
                }

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 || nr == m || nc == n || grid[nr][nc] == 'X') {
                        continue;
                    }

                    int ne = grid[nr][nc] == 'R' ? energy : e - 1;
                    int nl = grid[nr][nc] < k ? l | (1 << (int) grid[nr][nc]) : l;

                    if (!visit[nr][nc][ne][nl]) {
                        q.offer(new int[] {nr, nc, ne, nl});
                        visit[nr][nc][ne][nl] = true;
                    }
                }
            }

            result++;
        }

        return -1;
    }
}
