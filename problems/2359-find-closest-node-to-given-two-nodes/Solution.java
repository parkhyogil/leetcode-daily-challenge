class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        calculateDistance(node1, edges, dist1);
        calculateDistance(node2, edges, dist2);

        int min = n;
        int result = -1;

        for (int i = 0; i < n; i++) {
            int max = Math.max(dist1[i], dist2[i]);
            
            if (dist1[i] != -1 && dist2[i] != -1 && min > max) {
                min = max;
                result = i;
            }
        }

        return result;
    }

    private void calculateDistance(int node, int[] edges, int[] distance) {
        Arrays.fill(distance, -1);

        int dist = 0;
        while (node != -1 && distance[node] == -1) {
            distance[node] = dist++;
            node = edges[node];
        }
    }
}
