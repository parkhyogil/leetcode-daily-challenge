class Solution {
    class DisjointSet {
        private int size;
        private int[] root, setSize;

        public DisjointSet(int size) {
            this.size = size;

            root = new int[size];
            setSize = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                setSize[i] = 1;
            }
        }

        public boolean union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            if (a == b) {
                return false;
            }

            if (a < b) {
                root[b] = a;
                setSize[a] += setSize[b];
            } else {
                root[a] = b;
                setSize[b] += setSize[a];
            }

            return true;
        }

        public int findRoot(int child) {
            if (root[child] == child) {
                return child;
            }
            return root[child] = findRoot(root[child]);
        }

        public boolean isFullyTraversable() {
            return setSize[0] == size;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        List<List<int[]>> edgesByType = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            edgesByType.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            edgesByType.get(edge[0] - 1).add(edge);
        }

        int numOfEdges = edges.length;
        int numOfUsedEdges = 0;

        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);

        for (int[] edge : edgesByType.get(2)) {
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            
            if (alice.union(u, v)) {
                bob.union(u, v);

                numOfUsedEdges++;
            }
        }

        for (int[] edge : edgesByType.get(0)) {
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            
            if (alice.union(u, v)) {
                numOfUsedEdges++;
            }
        }

        if (!alice.isFullyTraversable()) {
            return -1;
        }

        for (int[] edge : edgesByType.get(1)) {
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            
            if (bob.union(u, v)) {
                numOfUsedEdges++;
            }
        }

        if (!bob.isFullyTraversable()) {
            return -1;
        }

        return numOfEdges - numOfUsedEdges;
    }
}
