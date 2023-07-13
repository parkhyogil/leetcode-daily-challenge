class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        List<List<Integer>> graph = makeGraph(n, prerequisites);

        boolean[] visit = new boolean[n];
        boolean[] hasCycle = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, visit, hasCycle)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, boolean[] visit, boolean[] hasCycle) {
        if (visit[node]) {
            return hasCycle[node];
        }

        visit[node] = true;
        hasCycle[node] = true;
        for (int next : graph.get(node)) {
            if (dfs(next, graph, visit, hasCycle)) {
                return true;
            }
        }
        return hasCycle[node] = false;
    }

    private List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            res.get(e[0]).add(e[1]);
        }
        return res;
    }
}
