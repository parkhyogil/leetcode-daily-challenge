class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];

        for (int[] q : queries) {
            int r0 = q[0], c0 = q[1], r1 = q[2] + 1, c1 = q[3] + 1;

            result[r0][c0]++;
            if (r1 < n) {
                result[r1][c0]--;
            }
            if (c1 < n) {
                result[r0][c1]--;
                if (r1 < n) {
                    result[r1][c1]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    result[i][j] += result[i - 1][j];
                }
                if (j > 0) {
                    result[i][j] += result[i][j - 1];
                    if (i > 0) {
                        result[i][j] -= result[i - 1][j - 1];
                    }
                }
            }
        }

        return result;
    }
}
