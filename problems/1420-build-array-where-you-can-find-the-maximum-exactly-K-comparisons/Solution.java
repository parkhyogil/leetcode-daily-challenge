class Solution {
    private int[][][] cache;
    private int mod = (int) 1e9 + 7;

    public int numOfArrays(int n, int m, int k) {
        cache = new int[n + 1][m + 2][k + 1];
        for (int[][] mat : cache) {
            for (int[] arr : mat) {
                Arrays.fill(arr, -1);
            }
        }

        return recur(n, m, k, m + 1);
    }

    private int recur(int n, int m, int k, int min) {
        if (k < 0) {
            return 0;
        }

        if (n == 0) {
            return k == 0 ? 1 : 0;
        }

        if (cache[n][min][k] != -1) {
            return cache[n][min][k];
        }

        long res = 0;
        for (int curr = 1; curr <= m; curr++) {
            if (curr < min) {
                res += recur(n - 1, m, k - 1, curr);
            } else {
                res += recur(n - 1, m, k, min);
            }
        }
        return cache[n][min][k] = (int) (res % mod);
    }
}
