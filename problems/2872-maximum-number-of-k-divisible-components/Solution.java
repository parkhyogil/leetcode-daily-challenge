class Solution {
    int result;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = buildGraph(n, edges);

        result = 0;
        
        postorder(0, -1, graph, values, k);

        return result;
    }

    long postorder(int node, int parent, List<List<Integer>> graph, int[] values, int k) {
        long sum = values[node];

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            sum += postorder(child, node, graph, values, k);
        }

        if (sum % k == 0) {
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

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
