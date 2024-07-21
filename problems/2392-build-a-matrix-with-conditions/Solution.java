class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowPos = getPos(k, rowConditions);
        if (rowPos == null) {
            return new int[][] {};
        }

        int[] colPos = getPos(k, colConditions);
        if (colPos == null) {
            return new int[][] {};
        }

        int[][] res = new int[k][k];

        for (int i = 0; i < k; i++) {
            res[rowPos[i]][colPos[i]] = i + 1;
        }

        return res;
    }

    private int[] getPos(int k, int[][] conditions) {
        List<List<Integer>> graph = makeGraph(k, conditions);
        int[] indegree = countIndegree(k, graph);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int pos = 0;
        int[] res = new int[k];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[node] = pos++;

            for (int next : graph.get(node)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return pos == k ? res : null;
    }

    private int[] countIndegree(int n, List<List<Integer>> graph) {
        int[] res = new int[n];

        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                res[v]++;
            }
        }

        return res;
    }

    private List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            res.get(edge[0] - 1).add(edge[1] - 1);
        }

        return res;
    }
}
