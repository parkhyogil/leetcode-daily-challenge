class Solution {
    public int minCost(int n, int[][] edges) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<List<int[]>> graph = new ArrayList<>();
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            cost[i] = Integer.MAX_VALUE;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            graph.get(u).add(new int[] {v, w});
            graph.get(v).add(new int[] {u, w * 2});
        }

        queue.offer(new int[] {0, 0});
        cost[0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int u = cur[0], c = cur[1];

            if (c > cost[u]) {
                continue;
            }

            if (u == n - 1) {
                return c;
            }

            for (int[] e : graph.get(u)) {
                int v = e[0], w = e[1];

                if (c + w < cost[v]) {
                    queue.offer(new int[] {v, c + w});
                    cost[v] = c + w;
                }
            }
        }

        return -1;
    }
}
