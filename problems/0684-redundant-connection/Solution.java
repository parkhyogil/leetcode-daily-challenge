class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (ds.isConnected(u, v)) {
                return edge;
            }

            ds.connect(u, v);
        }

        return new int[0];
    }

    class DisjointSet {
        private int size;
        private int[] roots;

        public DisjointSet(int size) {
            this.size = size;
            roots = new int[size + 1];

            for (int i = 1; i <= size; i++) {
                roots[i] = i;
            }
        }

        public boolean isConnected(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

        public void connect(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            if (a < b) {
                roots[b] = a;
            } else {
                roots[a] = b;
            }
        }

        private int findRoot(int child) {
            if (roots[child] == child) {
                return child;
            }
            return roots[child] = findRoot(roots[child]);
        }
    }
}
