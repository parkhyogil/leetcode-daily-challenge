class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 12345;

        int[][] p = new int[m][n];
        int x = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = x;
                x = x * (grid[i][j] % mod) % mod;
            }
        }

        x = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                p[i][j] = p[i][j] * x % mod;
                x = x * (grid[i][j] % mod) % mod;
            }
        }

        return p;
    }
}
