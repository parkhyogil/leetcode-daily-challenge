class Solution {
    int mod = (int) 1e9 + 7;    

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int[][][] dp = new int[n][n][2];
        dp[n - 1][n - 1] = new int[] {0, 1};

        for (int i = n - 2; i >= 0; i--) {
            char c = board.get(n - 1).charAt(i);
            if (c == 'X') {
                break;
            }

            calc(dp[n - 1][i], dp[n - 1][i + 1]);
            dp[n - 1][i][0] += c - '0';
        }
        
        for (int i = n - 2; i >= 0; i--) {
            char c = board.get(i).charAt(n - 1);
            if (c == 'X') {
                break;
            }

            calc(dp[i][n - 1], dp[i + 1][n - 1]);
            dp[i][n - 1][0] += c - '0';
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                char c = board.get(i).charAt(j);

                if (c == 'X') {
                    continue;
                }

                calc(dp[i][j], dp[i + 1][j]);
                calc(dp[i][j], dp[i][j + 1]);
                calc(dp[i][j], dp[i + 1][j + 1]);

                if (c != 'E') {
                    dp[i][j][0] += c - '0';
                    dp[i][j][0] %= mod;
                }

                if (dp[i][j][1] == 0) {
                    dp[i][j][0] = 0;
                }
            }
        }

        return dp[0][0];
    }

    void calc(int[] a, int[] b) {
        if (b[1] == 0) {
            return;
        }

        if (b[0] > a[0]) {
            a[0] = b[0];
            a[1] = b[1];
        } else if (b[0] == a[0]) {
            a[1] = (a[1] + b[1]) % mod;
        }
    }
}
