class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = buildGraph(n, roads);

        int[] numWays = new int[n];
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);

        numWays[0] = 1;
        time[0] = 0;

        PriorityQueue<Pair<Integer, Long>> queue = new PriorityQueue<>((a, b) -> Long.compare(a.getValue(), b.getValue()));
        queue.offer(new Pair(0, 0L));

        while (!queue.isEmpty()) {
            Pair<Integer, Long> curr = queue.poll();

            int u = curr.getKey();
            long t = curr.getValue();

            if (u == n - 1) {
                break;
            }

            if (t > time[u]) {
                continue;
            }

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                long nextTime = t + w;

                if (nextTime < time[v]) {
                    time[v] = nextTime;
                    numWays[v] = numWays[u];
                    queue.offer(new Pair(v, nextTime));
                } else if (nextTime == time[v]) {
                    numWays[v] = (numWays[v] + numWays[u]) % 1000000007;
                }
            }
        }

        return numWays[n - 1];
    }

    private List<List<int[]>> buildGraph(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[] {v, w});
            graph.get(v).add(new int[] {u, w});
        }

        return graph;
    }
}
