class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        boolean[][] isDirectlyConnected = new boolean[n][n];

        for (int[] r : roads) {
            int a = r[0];
            int b = r[1];

            count[a]++;
            count[b]++;

            isDirectlyConnected[a][b] = true;
            isDirectlyConnected[b][a] = true;
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = count[i] + count[j];
                if (isDirectlyConnected[i][j]) {
                    rank--;
                }

                res = Math.max(res, rank);
            }
        }

        return res;
    }
}
