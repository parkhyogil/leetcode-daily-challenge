class Solution {
    int[] pref;
    int[][] cache;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        pref = new int[n + 1];
        cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stoneValue[i];
            Arrays.fill(cache[i], -1);
        }

        return recur(0, n - 1);
    }

    int recur(int l, int r) {
        if (l == r) {
            return 0;
        }

        if (cache[l][r] > 0) {
            return cache[l][r];
        }

        int max = 0;

        for (int i = l; i < r; i++) {
            int left = pref[i + 1] - pref[l];
            int right = pref[r + 1] - pref[i + 1];

            if (left < right) {
                max = Math.max(max, left + recur(l, i));
            } else if (left > right) {
                max = Math.max(max, right + recur(i + 1, r));
            } else {
                max = Math.max(max, Math.max(left + recur(l, i), right + recur(i + 1, r)));
            }
        }

        return cache[l][r] = max;
    }
}
