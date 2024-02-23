class Solution {
    private final int MAX = 1000000000;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];

        for (int[] flight : flights) {
            graph[flight[1]][flight[0]] = flight[2];
        }

        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }

        int res = recur(dst, k + 1, src, graph, dist);
        
        return res == MAX ? -1 : res;
    }

    private int recur(int node, int k, int target, int[][] graph, int[][] dist) {
        if (node == target) {
            return 0;
        }

        if (k == 0) {
            return MAX;
        }

        if (dist[node][k] != -1) {
            return dist[node][k];
        }

        int res = MAX;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 0) {
                continue;
            }
            res = Math.min(res, graph[node][i] + recur(i, k - 1, target, graph, dist));
        }

        return dist[node][k] = res;
    }
}
