class Solution {
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int startR = 0;
        int startC = 0;
        int numOfKeys = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startR = i;
                    startC = j;
                } else if ('a' <= c && c <= 'f') {
                    numOfKeys++;
                }
            }
        }

        int endState = (1 << numOfKeys) - 1;
        boolean[][][] visit = new boolean[m][n][endState + 1];
        Queue<int[]> q = new LinkedList<>();

        visit[startR][startC][0] = true;
        q.offer(new int[] {startR, startC, 0});

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int keyState = curr[2];

                if (keyState == endState) {
                    return res;
                }

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    int nKeyState = keyState;

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || visit[nr][nc][keyState] || grid[nr].charAt(nc) == '#') {
                        continue;
                    }

                    char cell = grid[nr].charAt(nc);
                    if ('a' <= cell && cell <= 'f') {
                        nKeyState |= 1 << (cell - 'a');
                    } else if ('A' <= cell && cell <= 'F' && (keyState & (1 << (cell - 'A'))) == 0) {
                        continue;
                    }
                    visit[nr][nc][nKeyState] = true;
                    q.offer(new int[] {nr, nc, nKeyState});
                }
            }
            res++;
        }
        return -1;
    }
}
