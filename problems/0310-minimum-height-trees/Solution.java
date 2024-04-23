class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] edgeCount = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);

            edgeCount[u]++;
            edgeCount[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (edgeCount[i] == 1) {
                queue.offer(i);
            }
        }

        int nodeCount = n;
        while (nodeCount > 2) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();
                nodeCount--;

                for (int next : graph.get(curr)) {
                    edgeCount[curr]--;
                    edgeCount[next]--;

                    if (edgeCount[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
