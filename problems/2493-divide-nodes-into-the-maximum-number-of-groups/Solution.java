class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(n, edges);

        int result = 0;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            }

            List<Integer> components = new ArrayList<>();

            if (!isBipartite(i, 1, colors, graph, components)) {
                return -1;
            }

            result += findMaxGroupCount(components, graph);
        }

        return result;
    }

    int findMaxGroupCount(List<Integer> components, List<List<Integer>> graph) {
        int maxGroupCount = 0;

        for (int node : components) {
            maxGroupCount = Math.max(maxGroupCount, BFS(node, graph));
        }

        return maxGroupCount;
    }

    int BFS(int start, List<List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];

        queue.offer(start);
        visited[start] = true;

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int node = queue.poll();

                for (int next : graph.get(node)) {
                    if (visited[next]) {
                        continue;
                    }
                    queue.offer(next);
                    visited[next] = true;
                }
            }
            depth++;
        }
        return depth;
    }

    boolean isBipartite(int node, int color, int[] colors, List<List<Integer>> graph, List<Integer> components) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;
        components.add(node);

        for (int next : graph.get(node)) {
            if (!isBipartite(next, color * -1, colors, graph, components)) {
                return false;
            }
        }

        return true;
    }

    List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
