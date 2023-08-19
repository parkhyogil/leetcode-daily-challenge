class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;

        int[][] e = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                e[i][j] = edges[i][j];
            }
            e[i][3] = i;
        }

        Arrays.sort(e, (a, b) -> Integer.compare(a[2], b[2]));

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();

        DisjointSet ds = new DisjointSet(n);
        int MSTWeight = 0;

        for (int i = 0; i < m && ds.setCount > 1; i++) {
            if (ds.union(e[i][0], e[i][1])) {
                MSTWeight += e[i][2];
            }
        }

        for (int i = 0; i < m; i++) {
            DisjointSet deleted = new DisjointSet(n);
            int deletedWeight = 0;

            for (int j = 0; j < m && deleted.setCount > 1; j++) {
                if (i != j && deleted.union(e[j][0], e[j][1])) {
                    deletedWeight += e[j][2];
                }
            }

            if (deleted.setCount > 1 || MSTWeight < deletedWeight) {
                criticalEdges.add(e[i][3]);
            } else {
                DisjointSet forced = new DisjointSet(n);
                forced.union(e[i][0], e[i][1]);
                int forcedWeight = e[i][2];

                for (int j = 0; j < m && forced.setCount > 1; j++) {
                    if (forced.union(e[j][0], e[j][1])) {
                        forcedWeight += e[j][2];
                    }
                }

                if (MSTWeight == forcedWeight) {
                    pseudoCriticalEdges.add(e[i][3]);
                }
            }
        }

        return List.of(criticalEdges, pseudoCriticalEdges);     
    }

    class DisjointSet {
        int n, setCount;
        int[] root;

        public DisjointSet(int n) {
            this.n = n;
            setCount = n;
            root = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
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
            } else {
                root[a] = b;
            }
            setCount--;
            return true;
        }

        public int findRoot(int child) {
            if (root[child] == child) {
                return child;
            }
            return root[child] = findRoot(root[child]);
        }
    }
}
