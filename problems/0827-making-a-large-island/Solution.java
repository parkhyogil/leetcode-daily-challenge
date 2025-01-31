class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);
        int[] offset = new int[] {-1, 0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int r = i + offset[k];
                    int c = j + offset[k + 1];

                    if (isOutOfBoundary(r, c, n) || grid[r][c] == 0) {
                        continue;
                    }

                    ds.union(i * n + j, r * n + c);
                }
            }
        }

        boolean[] visited = new boolean[n * n];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, ds.getComponentSize(i * n + j));
                    continue;
                }

                int area = 1;
                int root;
                for (int k = 0; k < 4; k++) {
                    int r = i + offset[k];
                    int c = j + offset[k + 1];

                    if (isOutOfBoundary(r, c, n) || grid[r][c] == 0 || visited[root = ds.findRoot(r * n + c)]) {
                        continue;
                    }

                    area += ds.getComponentSize(root);
                    visited[root] = true;
                }

                maxArea = Math.max(maxArea, area);

                for (int k = 0; k < 4; k++) {
                    int r = i + offset[k];
                    int c = j + offset[k + 1];

                    if (isOutOfBoundary(r, c, n) || grid[r][c] == 0) {
                        continue;
                    }
                    visited[ds.findRoot(r * n + c)] = false;
                }
            }
        }

        return maxArea;
    }

    boolean isOutOfBoundary(int r, int c, int n) {
        return r < 0 || c < 0 || r == n || c == n;
    }
}

class DisjointSet {
    private int size;
    private int[] roots, componentSize;

    public DisjointSet(int n) {
        size = n;
        roots = new int[size];
        componentSize = new int[size];

        for (int i = 0; i < size; i++) {
            roots[i] = i;
            componentSize[i] = 1;
        }
    }

    public void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a == b) {
            return;
        }

        if (a < b) {
            roots[b] = a;
            componentSize[a] += componentSize[b];
        } else {
            roots[a] = b;
            componentSize[b] += componentSize[a];
        }
    }

    public int getComponentSize(int idx) {
        return componentSize[findRoot(idx)];
    }

    public int findRoot(int child) {
        if (child == roots[child]) {
            return child;
        }
        return roots[child] = findRoot(roots[child]);
    }
}
