class Solution {
    private final int MAX = Integer.MAX_VALUE;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int m = source.length();
        
        int[][] distanceMatrix = calculateDistanceMatrix(original, changed, cost);
        long res = 0;

        for (int i = 0; i < m; i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';

            if (distanceMatrix[u][v] == MAX) {
                return -1;
            }

            res += distanceMatrix[u][v];
        }

        return res;
    }

    private int[][] calculateDistanceMatrix(char[] original, char[] changed, int[] cost) {
        int n = original.length;

        int[][] res = new int[26][26];

        for (int[] arr : res) {
            Arrays.fill(arr, MAX);
        }

        for (int i = 0; i < 26; i++) {
            res[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];

            res[u][v] = Math.min(res[u][v], w);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (res[i][k] != MAX && res[k][j] != MAX) {
                        res[i][j] = Math.min(res[i][j], res[i][k] + res[k][j]);
                    }
                }
            }
        }

        return res;
    }
}
