class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        List<List<Integer>> graph = buildGraph(n, edges);

        int[] parents = new int[n];
        findParentNode(0, -1, graph, parents);      

        int depth = getDepth(bob, parents);

        for (int i = 0; i < depth / 2; i++) {
            amount[bob] = 0;
            bob = parents[bob];
        }

        if (depth % 2 == 1) {
            amount[bob] /= 2;
        }

        return findMaxProfit(0, graph, amount, parents);
    }

    int getDepth(int node, int[] parents) {
        int depth = 0;

        while (node != -1) {
            node = parents[node];
            depth++;
        }

        return depth;
    }

    int findMaxProfit(int node, List<List<Integer>> graph, int[] amount, int[] parents) {
        if (isLeafNode(node, graph.get(node), parents)) {
            return amount[node];
        }

        int max = Integer.MIN_VALUE;

        for (int child : graph.get(node)) {
            if (child == parents[node]) {
                continue;
            }

            max = Math.max(max, findMaxProfit(child, graph, amount, parents));
        }

        return max + amount[node];
    }

    boolean isLeafNode(int node, List<Integer> children, int[] parents) {
        return children.size() == 1 && parents[node] == children.get(0);
    }

    void findParentNode(int node, int parent, List<List<Integer>> graph, int[] parents) {
        parents[node] = parent;

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            findParentNode(child, node, graph, parents);
        }
    }

    List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
