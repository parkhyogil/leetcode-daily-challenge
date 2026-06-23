class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l;
        int mod = (int) 1e9 + 7;

        int[] inc = new int[m + 1];
        int[] dec = new int[m + 1];

        for (int i = 0; i <= m; i++) {
            inc[i] = i;
            dec[i] = m - i;
        }

        for (int i = 0; i < m; i++) {
            inc[m - i - 1] += inc[m - i];
            dec[i + 1] += dec[i];
        }

        for (int i = 3; i <= n; i++) {
            int[] nextInc = new int[m + 1];
            int[] nextDec = new int[m + 1];

            for (int j = 0; j <= m; j++) {
                if (j > 0) {
                    nextInc[j] = dec[j - 1];
                }
                if (j < m) {
                    nextDec[j] = inc[j + 1];
                }
            }

            inc = nextInc;
            dec = nextDec;

            for (int j = 0; j < m; j++) {
                inc[m - j - 1] = (inc[m - j - 1] + inc[m - j]) % mod;
                dec[j + 1] = (dec[j] + dec[j + 1]) % mod;
            }
        }

        return (inc[0] + dec[m - 1]) % mod;
    }
}
