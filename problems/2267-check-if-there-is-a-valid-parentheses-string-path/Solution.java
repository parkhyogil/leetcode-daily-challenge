class Solution {
    int m, n, l;
    char[][] grid;
    int[][][] cache;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        l = (m + n) / 2;
        this.grid = grid;

        if ((m + n - 1) % 2 != 0 || grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        cache = new int[m][n][l + 1];

        return recur(m - 1, n - 1, 0);
    }

    boolean recur(int i, int j, int b) {
        if (i < 0 || j < 0 || b < 0 || b > l) {
            return false;
        }

        if (i == 0 && j == 0) {
            return b == 1 && grid[i][j] == '(';
        }

        if (cache[i][j][b] > 0) {
            return cache[i][j][b] == 1;
        }

        char c = grid[i][j];
        int nb;

        if (c == '(') {
            nb = b - 1;
        } else {
            nb = b + 1;
        }

        boolean res = recur(i - 1, j, nb) || recur(i, j - 1, nb);

        cache[i][j][b] = res ? 1 : 2;
        
        return res;
    }
}
