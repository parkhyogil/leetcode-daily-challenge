class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;

        int[][] dir = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        int[][] grid = new int[row][col];
        int[] roots = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            int j = r * col + c;

            grid[r][c] = 1;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr == row) {
                    continue;
                }

                if (nc < 0) {
                    union(j, n, roots);
                } else if (nc == col) {
                    union(j, n + 1, roots);
                } else if (grid[nr][nc] == 1) {
                    union(j, nr * col + nc, roots);
                }
            }

            if (findRoot(n, roots) == findRoot(n + 1, roots)) {
                return i;
            }
        }

        return -1;
    }

    void union(int a, int b, int[] roots) {
        a = findRoot(a, roots);
        b = findRoot(b, roots);

        if (a < b) {
            roots[b] = a;
        } else {
            roots[a] = b;
        }
    }

    int findRoot(int x, int[] roots) {
        if (x == roots[x]) {
            return x;
        }
        return roots[x] = findRoot(roots[x], roots);
    }
}
