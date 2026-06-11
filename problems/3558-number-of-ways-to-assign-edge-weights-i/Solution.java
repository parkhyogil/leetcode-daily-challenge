class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> graph = build(n, edges);
        int depth = findDepth(0, -1, graph);

        return pow(2, depth - 1);
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

    int findDepth(int node, int parent, List<List<Integer>> graph) {
        int max = 0;

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            max = Math.max(max, findDepth(child, node, graph) + 1);
        }

        return max;
    }

    List<List<Integer>> build(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            result.get(e[0] - 1).add(e[1] - 1);
            result.get(e[1] - 1).add(e[0] - 1);
        }

        return result;
    }
}
