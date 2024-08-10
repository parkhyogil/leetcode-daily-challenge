class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        int gridSize = n + 1;

        DisjointSet ds = new DisjointSet(gridSize * gridSize);

        for (int i = 0; i + 1 < gridSize; i++) {
            ds.union(i, i + 1);
            ds.union((gridSize - 1) * gridSize + i, (gridSize - 1) * gridSize + i + 1);

            ds.union(i * gridSize, (i + 1) * gridSize);
            ds.union(i * gridSize + gridSize - 1, (i + 1) * gridSize + gridSize - 1);
        }

        int result = 1;

        for (int row = 0; row < n; row++) {
            String s = grid[row];

            for (int col = 0; col < n; col++) {
                char c = s.charAt(col);
                if (c == '/') {
                    if (!ds.union(row * gridSize + (col + 1), (row + 1) * gridSize + col)) {
                        result++;
                    }
                } else if (c == '\\') {
                    if (!ds.union(row * gridSize + col, (row + 1) * gridSize + (col + 1))) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    class DisjointSet {
        private int size;
        private int[] roots;

        public DisjointSet(int size) {
            this.size = size;
            roots = new int[size];

            for (int i = 0; i < size; i++) {
                roots[i] = i;
            }
        }

        public boolean union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            if (a == b) {
                return false;
            }

            if (a < b) {
                roots[b] = a;
            } else {
                roots[a] = b;
            }

            return true;
        }

        private int findRoot(int child) {
            if (child == roots[child]) {
                return child;
            }
            return roots[child] = findRoot(roots[child]);
        }
    }
}
