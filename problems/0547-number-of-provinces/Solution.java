class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visit = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                res++;
                dfs(i, isConnected, visit);
            }
        }
        return res;
    }

    private void dfs(int node, int[][] graph, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < graph.length; i++) {
            if (visit[i] || graph[node][i] == 0) {
                continue;
            }
            dfs(i, graph, visit);
        }
    }
}
