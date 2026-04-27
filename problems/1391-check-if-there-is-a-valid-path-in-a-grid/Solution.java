class Solution {
    int[] root;

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        root = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                root[i * n + j] = i * n + j;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];

                if (i - 1 >= 0) {
                    int y = grid[i - 1][j];

                    if ((x == 2 || x == 5 || x == 6) && (y == 2 || y == 3 || y == 4)) {
                        union(i * n + j, (i - 1) * n + j);
                    }
                }

                if (j - 1 >= 0) {
                    int y = grid[i][j - 1];

                    if ((x == 1 || x == 3 || x == 5) && (y == 1 || y == 4 || y == 6)) {
                        union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }

        return root[0] == findRoot(root[m * n - 1]);
    }

    void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    int findRoot(int a) {
        if (a == root[a]) {
            return a;
        }
        return root[a] = findRoot(root[a]);
    }
}
