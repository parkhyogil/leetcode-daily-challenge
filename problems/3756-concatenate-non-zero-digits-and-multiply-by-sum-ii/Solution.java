class Solution {
    int mod = (int) 1e9 + 7;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        int n = queries.length;

        long[] pow = new long[m + 1];
        long[] x = new long[m + 1];
        int[] sum = new int[m + 1];
        int[] count = new int[m + 1];

        pow[0] = 1;

        for (int i = 0; i < m; i++) {
            int j = s.charAt(i) - '0';

            pow[i + 1] = pow[i] * 10 % mod;
            x[i + 1] = x[i];
            sum[i + 1] = sum[i];
            count[i + 1] = count[i];

            if (j > 0) {
                x[i + 1] = (x[i + 1] * 10 + j) % mod;
                sum[i + 1] += j;
                count[i + 1]++;
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int l = queries[i][0], r = queries[i][1];

            long xx = (x[r + 1] - x[l] * pow[count[r + 1] - count[l]] % mod + mod) % mod;
            result[i] = (int) ((sum[r + 1] - sum[l]) * xx % mod);
        }

        return result;
    }
}
