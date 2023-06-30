class Solution {
    class DisjointSet {
        private int[] root;

        public DisjointSet(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public void union(int a, int b) {
            a = getRoot(a);
            b = getRoot(b);

            if (a < b) {
                root[b] = a;
            } else {
                root[a] = b;
            }
        }

        public int getRoot(int child) {
            if (root[child] == child) {
                return child;
            }
            return root[child] = getRoot(root[child]);
        }
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] dir = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        int[][] grid = new int[row][col];

        DisjointSet ds = new DisjointSet(row * col + 2);
        int top = 0;
        int bottom = row * col + 1;

        for (int i = 0; i < cells.length; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            int idx = r * col + c + 1;

            grid[r][c] = 1;
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= row || nc < 0 || nc >= col || grid[nr][nc] == 0) {
                    continue;
                }

                ds.union(idx, nr * col + nc + 1);
            }

            if (c == 0) {
                ds.union(idx, top);
            } else if (c == col - 1) {
                ds.union(idx, bottom);
            }

            if (ds.getRoot(top) == ds.getRoot(bottom)) {
                return i;
            }
        }
        return -1;
    }
}
