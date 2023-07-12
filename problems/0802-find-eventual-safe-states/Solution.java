class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> res = new ArrayList<>();
        boolean[] visit = new boolean[n];
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (recur(i, graph, visit, safe)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean recur(int node, int[][] graph, boolean[] visit, boolean[] safe) {
        if (visit[node]) {
            return safe[node];
        }

        visit[node] = true;
        for (int next : graph[node]) {
            if (!recur(next, graph, visit, safe)) {
                return false;
            }
        }
        return safe[node] = true;
    }
}
