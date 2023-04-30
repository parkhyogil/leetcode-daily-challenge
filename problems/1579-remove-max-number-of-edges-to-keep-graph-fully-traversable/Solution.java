class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);

        int res = 0;
        for (int[] e : edges) {
            int type = e[0];
            int u = e[1] - 1;
            int v = e[2] - 1;

            if (type == 3) {
                if (alice.isConnected(u, v)) {
                    res++;
                } else {
                    alice.union(u, v);
                    bob.union(u, v);
                }
            }
        }
        for (int[] e : edges) {
            int type = e[0];
            int u = e[1] - 1;
            int v = e[2] - 1;

            if (type == 1) {
                if (alice.isConnected(u, v)) {
                    res++;
                } else {
                    alice.union(u, v);
                }
            } else if (type == 2) {
                if (bob.isConnected(u, v)) {
                    res++;
                } else {
                    bob.union(u, v);
                }
            }
        }
        return alice.isAllConnected() && bob.isAllConnected() ? res : -1;
    }

    class DisjointSet {
        private int n;
        private int[] root;

        public DisjointSet(int n) {
            this.n = n;
            this.root = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int findRoot(int child) {
            if (root[child] == child) {
                return child;
            }
            return root[child] = findRoot(root[child]);
        }

        public void union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            if (a < b) {
                root[b] = a;
            } else {
                root[a] = b;
            }
        }

        public boolean isConnected(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

        public boolean isAllConnected() {
            int r = findRoot(0);
            for (int i = 1; i < n; i++) {
                if (r != findRoot(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
