class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length;
        int m = edges2.length;

        List<List<Integer>> graph1 = buildGraph(n + 1, edges1);
        List<List<Integer>> graph2 = buildGraph(m + 1, edges2);

        int dia1 = getDiameter(0, -1, graph1)[0];
        int dia2 = getDiameter(0, -1, graph2)[0];

        return Math.max(dia1, Math.max(dia2, (dia1 - dia1 / 2) + (dia2 - dia2 / 2) + 1));
    }

    private int[] getDiameter(int node, int parent, List<List<Integer>> graph) {
        int diameter = 0;
        int max1 = 0;
        int max2 = 0;

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            int[] dia = getDiameter(child, node, graph);
            diameter = Math.max(diameter, dia[0]);

            if (dia[1] > max1) {
                max2 = max1;
                max1 = dia[1];
            } else if (dia[1] > max2) {
                max2 = dia[1];
            }
        }

        return new int[] {Math.max(diameter, max1 + max2), max1 + 1};
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
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
