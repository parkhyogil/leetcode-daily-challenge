class Solution {
    List<List<Integer>> graph;
    int[] depth;
    int[][] parent;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int m = queries.length;

        buildGraph(n, edges);

        depth = new int[n];
        parent = new int[n][32 - Integer.numberOfLeadingZeros(n)];
        for (int[] arr : parent) {
            Arrays.fill(arr, -1);
        }
        dfs(0, 0, -1);

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0] - 1, v = queries[i][1] - 1;

            result[i] = u == v ? 0 : pow(2, getLength(u, v) - 1);
        }

        return result;
    }

    int getLength(int u, int v) {
        if (depth[u] > depth[v]) {
            return getLength(v, u);
        }

        int diff = depth[v] - depth[u];
        int len = diff;

        for (int i = 0; diff > 0; i++) {
            if (diff % 2 == 1) {
                v = parent[v][i];
            }
            diff /= 2;
        }

        if (u == v) {
            return len;
        }

        for (int i = parent[0].length - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];

                len += pow(2, i) * 2;
            }
        }

        return len + 2;
    }

    int pow(long b, long e) {
        long result = 1;
        int mod = (int) 1e9 + 7;

        while (e > 0) {
            if (e % 2 == 1) {
                result = result * b % mod;
            }
            b = b * b % mod;
            e /= 2;
        }

        return (int) result;
    }

    void dfs(int d, int i, int p) {
        depth[i] = d;

        parent[i][0] = p;
        for (int j = 1; j < parent[i].length; j++) {
            if (parent[i][j - 1] == -1) {
                break;
            }
            parent[i][j] = parent[parent[i][j - 1]][j - 1];
        }

        for (int c : graph.get(i)) {
            if (c == p) {
                continue;
            }

            dfs(d + 1, c, i);
        }
    }

    void buildGraph(int n, int[][] edges) {
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
}
