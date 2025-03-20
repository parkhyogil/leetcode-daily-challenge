class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int m = query.length;

        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            ds.union(u, v, w);
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int s = query[i][0];
            int t = query[i][1];

            result[i] = ds.isConnected(s, t) ? ds.getMinCost(s) : -1;
        }

        return result;
    }

    class DisjointSet {
        private int[] root, weight;

        public DisjointSet(int size) {
            root = new int[size];
            weight = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                weight[i] = Integer.MAX_VALUE;
            }
        }

        public void union(int u, int v, int w) {
            u = findRoot(u);
            v = findRoot(v);

            if (u < v) {
                root[v] = u;
                weight[u] &= weight[v] & w;
            } else {
                root[u] = v;
                weight[v] &= weight[u] & w;
            }
        }

        public boolean isConnected(int u, int v) {
            return findRoot(u) == findRoot(v);
        }

        public int getMinCost(int v) {
            return weight[findRoot(v)];
        }

        private int findRoot(int v) {
            if (root[v] == v) {
                return v;
            }
            return root[v] = findRoot(root[v]);
        }
    }
}
