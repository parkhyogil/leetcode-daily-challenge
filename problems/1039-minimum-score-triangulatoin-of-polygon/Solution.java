class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        
        return recur(0, n - 1, values, new int[n][n]);
    }

    int recur(int l, int r, int[] arr, int[][] cache) {
        if (r - l < 2) {
            return 0;
        }

        if (cache[l][r] > 0) {
            return cache[l][r];
        }

        int result = Integer.MAX_VALUE;

        for (int i = l + 1; i < r; i++) {
            result = Math.min(result, arr[l] * arr[i] * arr[r] + recur(l, i, arr, cache) + recur(i, r, arr, cache));
        }

        return cache[l][r] = result;
    }
}
