class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();

        int[] zeroCount = new int[n];
        zeroCount[0] = s.charAt(0) == '0' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            zeroCount[i] = zeroCount[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int[][] cache = new int[n][32];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return recur(s, n - 1, k, 0, cache, zeroCount);
    }

    private int recur(String s, int idx, int k, int take, int[][] cache, int[] zeroCount) {
        if (idx < 0) {
            return 0;
        }

        if (k == 0) {
            return zeroCount[idx];
        }

        if (cache[idx][take] != -1) {
            return cache[idx][take];
        }

        int result = recur(s, idx - 1, k, take, cache, zeroCount);

        if (k > 0 || s.charAt(idx) == '0') {
            result = Math.max(result, recur(s, idx - 1, (k - s.charAt(idx) + '0') / 2, take + 1, cache, zeroCount) + 1);
        }

        return cache[idx][take] = result;
    }
}
