class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int val = 1;
        for (int s = 0, e = n - 1; s < e; s++, e--) {
            for (int c = s; c < e; c++) {
                res[s][c] = val++;
            }
            for (int r = s; r < e; r++) {
                res[r][e] = val++;
            }
            for (int c = e; c > s; c--) {
                res[e][c] = val++;
            }
            for (int r = e; r > s; r--) {
                res[r][s] = val++;
            }
        }

        if (n % 2 == 1) {
            res[n / 2][n / 2] = val;
        }
        return res;
    }
}
