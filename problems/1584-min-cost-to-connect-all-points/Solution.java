class Solution {
    private int n;
    private int[][] points;
    private int[] weight;
    private boolean[] connected;

    public int minCostConnectPoints(int[][] points) {
        n = points.length;
        this.points = points;
        connected = new boolean[n];
        weight = new int[n];

        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int node = getMinimumWeightNode();

            res += weight[node];
            connected[node] = true;

            updateWeight(node);
        }

        return res;
    }

    private void updateWeight(int node) {
        for (int i = 0; i < n; i++) {
            weight[i] = Math.min(weight[i], getWeight(points[node], points[i]));
        }
    }

    private int getMinimumWeightNode() {
        int node = -1;

        for (int i = 0; i < n; i++) {
            if (!connected[i] && (node == -1 || weight[node] > weight[i])) {
                node = i;
            }
        }
        
        return node;
    }

    private int getWeight(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
