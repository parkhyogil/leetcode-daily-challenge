class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int r = 0; r < m; r++) {
            if (grid[r][0] == 0) {
                for (int c = 0; c < n; c++) {
                    grid[r][c] ^= 1;
                }
            }
        }

        int val = 1;
        int res = 0;

        for (int c = n - 1; c >= 0; c--) {
            int oneCount = 0;
            
            for (int r = 0; r < m; r++) {
                if (grid[r][c] == 1) {
                    oneCount++;
                }
            }

            if (oneCount < m - oneCount) {
                oneCount = m - oneCount;
            }

            res += oneCount * val;
            val *= 2;
        }

        return res;
    }
}
