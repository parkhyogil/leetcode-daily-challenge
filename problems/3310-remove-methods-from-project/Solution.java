class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : invocations) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        boolean[] removed = new boolean[n];
        dfs(k, indegree, removed, graph);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                result.add(i);
            } else if (indegree[i] > 0) {
                result = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    result.add(j);
                }
                return result;
            }
        }

        return result;
    }

    void dfs(int i, int[] indegree, boolean[] removed, List<List<Integer>> graph) {
        if (removed[i]) {
            return;
        }

        removed[i] = true;

        for (int j : graph.get(i)) {
            indegree[j]--;
            dfs(j, indegree, removed, graph);
        }
    }
}
