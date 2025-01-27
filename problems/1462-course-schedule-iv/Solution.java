class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);

        boolean[][] isReachable = doTopologicalSort(numCourses, graph);

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            result.add(isReachable[u][v]);
        }

        return result;
    }

    private boolean[][] doTopologicalSort(int n, List<List<Integer>> graph) {
        boolean[][] isReachable = new boolean[n][n];
        int[] indegree = countIndegree(n, graph);

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                for (int i = 0; i < n; i++) {
                    if (isReachable[i][node]) {
                        isReachable[i][next] = true;
                    }
                }

                indegree[next]--;
                isReachable[node][next] = true;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return isReachable;
    }

    private int[] countIndegree(int n, List<List<Integer>> graph) {
        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }
        return indegree;
    }

    private List<List<Integer>> buildGraph(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }

        return graph;
    }
}
