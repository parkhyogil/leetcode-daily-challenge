class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(i, 1, graph, color)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int c, int[][] graph, int[] color) {
        if (color[node] != 0) {
            return c == color[node];
        }
        color[node] = c;
        for (int next : graph[node]) {
            if (!dfs(next, c * - 1, graph, color)) {
                return false;
            }
        }
        return true;
    }
}
