class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = makeGraph(n, edges);

        int[] numOfNodes = new int[n];
        int[] sumOfDistances = new int[n];

        calculateSumOfRoot(0, -1, graph, numOfNodes, sumOfDistances);

        calculateSumOfNodes(0, -1, graph, numOfNodes, sumOfDistances);

        return sumOfDistances;
    }

    private void calculateSumOfNodes(int node, int parent, List<List<Integer>> graph, int[] numOfNodes, int[] sumOfDistances) {
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            sumOfDistances[child] = sumOfDistances[node] - numOfNodes[child] + numOfNodes[0] - numOfNodes[child];
            calculateSumOfNodes(child, node, graph, numOfNodes, sumOfDistances);
        }
    }

    private void calculateSumOfRoot(int node, int parent, List<List<Integer>> graph, int[] numOfNodes, int[] sumOfDistances) {
        numOfNodes[node] = 1;
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            calculateSumOfRoot(child, node, graph, numOfNodes, sumOfDistances);
            numOfNodes[node] += numOfNodes[child];
            sumOfDistances[node] += sumOfDistances[child] + numOfNodes[child];
        }
    }

    private List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            res.get(u).add(v);
            res.get(v).add(u);
        }

        return res;
    }
}
