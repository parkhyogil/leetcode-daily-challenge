class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        int[][] cost = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[] {e[1], e[2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        q.offer(new int[] {0, 0, 1});
        cost[0][1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0];
            int w = cur[1];
            int f = cur[2];

            if (u == n - 1) {
                return w;
            }

            for (int[] e : graph.get(u)) {
                int v = e[0];
                int nw = w + e[1];
                int nf = labels.charAt(v) == labels.charAt(u) ? f + 1 : 1;

                if (nf <= k && nw < cost[v][nf]) {
                    q.offer(new int[] {v, nw, nf});
                    cost[v][nf] = nw;
                }
            }
        }

        return -1;
    }
}
