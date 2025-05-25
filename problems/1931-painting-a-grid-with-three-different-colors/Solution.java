class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int colorTheGrid(int m, int n) {
        List<Integer> possibleColumns = new ArrayList<>();

        buildPossibleColumns(m, 0, -1, possibleColumns);

        int k = possibleColumns.size();

        boolean[][] canConnect = new boolean[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i == j) {
                    continue;
                }

                canConnect[i][j] = true;

                int a = possibleColumns.get(i);
                int b = possibleColumns.get(j);

                while (a > 0) {
                    if (a % 4 == b % 4) {
                        canConnect[i][j] = false;
                        break;
                    }
                    a /= 4;
                    b /= 4;
                }
            }
        }

        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int sum = 0;

                for (int l = 0; l < k; l++) {
                    if (canConnect[j][l]) {
                        sum = (sum + dp[i - 1][l]) % MOD;
                    }
                }

                dp[i][j] = sum;
            }
        }

        int result = 0;

        for (int i = 0; i < k; i++) {
            result = (result + dp[n - 1][i]) % MOD;
        }

        return result;
    }

    private void buildPossibleColumns(int m, int mask, int color, List<Integer> possibleColumns) {
        if (m == 0) {
            possibleColumns.add(mask);
            return;
        }

        mask *= 4;

        for (int i = 1; i < 4; i++) {
            if (i != color) {
                buildPossibleColumns(m - 1, mask + i, i, possibleColumns);
            }
        }
    }
}
