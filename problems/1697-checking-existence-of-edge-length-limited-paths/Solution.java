class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        int m = queries.length;
        Map<int[], Integer> qIdx = new HashMap<>();
        for (int i = 0; i < m; i++) {
            qIdx.put(queries[i], i);
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);

        boolean[] res = new boolean[m];
        int edgeIdx = 0;
        for (int[] query : queries) {
            int idx = qIdx.get(query);
            int u = query[0];
            int v = query[1];
            int limit = query[2];

            while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit) {
                union(edgeList[edgeIdx][0], edgeList[edgeIdx][1], root);
                edgeIdx++;
            }

            res[idx] = findRoot(u, root) == findRoot(v, root);
        }
        return res;
    }

    private void union(int a, int b, int[] root) {
        a = findRoot(a, root);
        b = findRoot(b, root);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    private int findRoot(int child, int[] root) {
        if (child == root[child]) {
            return child;
        }
        return root[child] = findRoot(root[child], root);
    }
}
