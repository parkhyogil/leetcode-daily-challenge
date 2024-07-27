class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        int[] total = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : relations) {
            graph.get(r[0] - 1).add(r[1] - 1);
            indegree[r[1] - 1]++;
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (total[i] == 0) {
                res = Math.max(res, recur(i, graph, indegree, total, time));
            }
        }

        return res;
    }

    private int recur(int node, List<List<Integer>> graph, int[] indegree, int[] total, int[] time) {
        if (indegree[node] > 0) {
            return 0;
        }

        total[node] += time[node];

        int res = total[node];
        for (int next : graph.get(node)) {
            indegree[next]--;

            total[next] = Math.max(total[next], total[node]);

            res = Math.max(res, recur(next, graph, indegree, total, time));
        }
        return res;
    }
}
