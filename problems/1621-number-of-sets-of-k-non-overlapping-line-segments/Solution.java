class Solution {
    int mod = (int) 1e9 + 7;
    int[][][] cache;

    public int numberOfSets(int n, int k) {
        cache = new int[n][k + 1][2];

        for (int[][] a : cache) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return recur(n - 1, k, 0);
    }

    int recur(int i, int k, int s) {
        if (k == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (cache[i][k][s] > -1) {
            return cache[i][k][s];
        }

        if (s == 0) {
            return cache[i][k][s] = (recur(i - 1, k, 0) + recur(i - 1, k, 1)) % mod;
        } else {
            return cache[i][k][s] = (recur(i - 1, k, 1) + recur(i, k - 1, 0)) % mod;
        }
    }
}
