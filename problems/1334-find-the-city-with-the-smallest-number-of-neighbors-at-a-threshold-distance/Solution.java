class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distanceMatrix = computeDistance(n, edges);

        int minNumOfReachableCities = n;
        int res = -1;

        for (int i = 0; i < n; i++) {
            int numOfReachableCities = countReachableCities(distanceMatrix[i], distanceThreshold);
            if (numOfReachableCities <= minNumOfReachableCities) {
                minNumOfReachableCities = numOfReachableCities;
                res = i;
            }
        }

        return res;
    }

    private int[][] computeDistance(int n, int[][] edges) {
        int[][] res = new int[n][n];
        
        for (int[] arr : res) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            res[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            res[u][v] = res[v][u] = w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (res[i][k] != Integer.MAX_VALUE && res[k][j] != Integer.MAX_VALUE) {
                        res[i][j] = Math.min(res[i][j], res[i][k] + res[k][j]);
                    }
                }
            }
        }

        return res;
    }

    private int countReachableCities(int[] distance, int threshold) {
        int res = 0;

        for (int dist : distance) {
            if (dist <= threshold) {
                res++;
            }
        }

        return res;
    }
}
