class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int m = queries.length;
        int mod = (int) 1e9 + 7;

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long p = 1;

            for (int j = 0, k = 0; j < 31 && k <= r; j++) {
                if ((n & 1 << j) > 0) {
                    if (l <= k && k <= r) {
                        p = p * (1 << j) % mod;
                    }
                    k++;
                }
            }

            result[i] = (int) p;
        }

        return result;
    }
}
