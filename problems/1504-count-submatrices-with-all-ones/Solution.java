class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] width = new int[m][n];

        int result = 0;

        for (int i = 0; i < m; i++) {
            int w = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    w = 0;
                    continue;
                }

                width[i][j] = ++w;

                int minW = n;

                for (int k = i; k >= 0 && width[k][j] > 0; k--) {
                    minW = Math.min(minW, width[k][j]);

                    result += minW;
                }
            }
        }

        return result;
    }
}
