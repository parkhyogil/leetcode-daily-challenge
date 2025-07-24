class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        List<List<Integer>> graph = buildGraph(n, edges);

        int min = Integer.MAX_VALUE;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            min = Math.min(min, getMin(n, u, v, nums, graph));
        }

        return min;
    }

    int getMin(int n, int u, int v, int[] nums, List<List<Integer>> graph) {
        int[] treeXOR = new int[n];
        int[] treeId = new int[n];

        Arrays.fill(treeXOR, -1);

        int x = dfs(u, v, 1, nums, treeXOR, treeId, graph);
        int y = dfs(v, u, 2, nums, treeXOR, treeId, graph);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == u || i == v) {
                continue;
            }

            int a = treeXOR[i];
            int b = treeId[i] == 1 ? y : x;
            int c = treeId[i] == 1 ? x ^ a : y ^ a;

            min = Math.min(min, Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));
        }

        return min;
    }

    int dfs(int node, int parent, int id, int[] nums, int[] treeXOR, int[] treeId, List<List<Integer>> graph) {
        int result = nums[node];
        treeId[node] = id;

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            result ^= dfs(child, node, id, nums, treeXOR, treeId, graph);
        }

        return treeXOR[node] = result;
    }

    List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return graph;
    }
}
