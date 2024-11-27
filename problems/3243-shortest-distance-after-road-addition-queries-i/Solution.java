class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;

        List<List<Integer>> graph = new ArrayList<>();
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            graph.get(u).add(v);
            
            if (dist[u] + 1 < dist[v]) {
                dist[v] = dist[u] + 1;

                bfs(graph, dist, v);
            }

            result[i] = dist[n - 1];
        }

        return result;
    }

    void bfs(List<List<Integer>> graph, int[] dist, int start) {
        int d = dist[start];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int node = queue.poll();

                for (int next : graph.get(node)) {
                    if (d + 1 >= dist[next]) {
                        continue;
                    }

                    queue.offer(next);
                    dist[next] = d + 1;
                }
            }

            d++;
        }
    }
}
