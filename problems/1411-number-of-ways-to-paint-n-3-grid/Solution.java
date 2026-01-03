class Solution {
    public int numOfWays(int n) {
        int[][][] dp = new int[3][3][3];
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j][k] = 1;
                }
            }
        }

        for (int t = 2; t <= n; t++) {
            int[][][] next = new int[3][3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        continue;
                    }
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        }
                        for (int pi = 0; pi < 3; pi++) {
                            if (i == pi) {
                                continue;
                            }
                            for (int pj = 0; pj < 3; pj++) {
                                if (pj == pi || j == pj) {
                                    continue;
                                }
                                for (int pk = 0; pk < 3; pk++) {
                                    if (pk == pj || pk == k) {
                                        continue;
                                    }
                                    next[i][j][k] = (next[i][j][k] + dp[pi][pj][pk]) % mod;
                                }
                            }
                        }
                    }
                }
            }

            dp = next;
        }

        int result = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }

                    result = (result + dp[i][j][k]) % mod;
                }
            }
        }

        return result;
    }
}
