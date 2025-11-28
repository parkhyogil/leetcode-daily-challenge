class Solution {
    int result;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = buildGraph(n, edges);

        result = 0;
        recur(-1, 0, k, values, graph);

        return result;
    }

    int recur(int parent, int node, int k, int[] values, List<List<Integer>> graph) {
        int sum = values[node] % k;

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            sum = (sum + recur(node, child, k, values, graph)) % k;
        }

        if (sum == 0) {
            result++;
            return 0;
        }

        return sum;
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
