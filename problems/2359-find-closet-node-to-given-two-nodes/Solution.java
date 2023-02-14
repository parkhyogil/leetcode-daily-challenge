class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = getDist(n, node1, edges);
        int[] dist2 = getDist(n, node2, edges);

        int res = -1;
        int minDist = n;
        for (int i = 0; i < n; i++) {
            int d = Math.max(dist1[i], dist2[i]);
            if (d < minDist) {
                minDist = d;
                res = i;
            }
        }
        return res;
    }

    private int[] getDist(int n, int node, int[] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, n);

        int d = 0;
        while (node != -1 && dist[node] == n) {
            dist[node] = d++;
            node = edges[node];
        }
        return dist;
    }
}
