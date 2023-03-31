class Solution {
    private final int MOD = (int) 1e9 + 7;

    private int m, n;
    private int[][] prefixSum;
    private Integer[][][] memo;

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();

        prefixSum = new int[m + 1][n + 1];
        memo = new Integer[k + 1][m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = pizza[i].charAt(j);
                prefixSum[i + 1][j + 1] = (c == 'A' ? 1 : 0) + prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j];
            }
        }

        return recur(0, 0, k, prefixSum[m][n]);
    }

    private int recur(int row, int col, int k, int restApple) {
        if (row == m || col == n || restApple == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        if (memo[k][row][col] != null) {
            return memo[k][row][col];
        }
        
        int res = 0;
        for (int i = row + 1; i < m; i++) {
            int next = getSum(i, col);
            if (next != restApple) {
                res += recur(i, col, k - 1, next);
                res %= MOD;
            }
        }
        for (int i = col + 1; i < n; i++) {
            int next = getSum(row, i);
            if (next != restApple) {
                res += recur(row, i, k - 1, next);
                res %= MOD;
            }
        }
        return memo[k][row][col] = res;
    }

    private int getSum(int r, int c) {
        return prefixSum[m][n] - prefixSum[r][n] - prefixSum[m][c] + prefixSum[r][c];
    }
}
