class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        int[][] cache = new int[n][d + 1];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        int res = recur(0, jobDifficulty, d, cache);
        return res > 10000 ? -1 : res;
    }

    private int recur(int idx, int[] jobDifficulty, int d, int[][] cache) {
        if (idx == jobDifficulty.length && d == 0) {
            return 0;
        }

        if (idx == jobDifficulty.length || d == 0) {
            return 10001;
        }

        if (cache[idx][d] != -1) {
            return cache[idx][d];
        }

        int max = jobDifficulty[idx];
        int res = max + recur(idx + 1, jobDifficulty, d - 1, cache);

        for (int i = idx + 1; i < jobDifficulty.length - d + 1; i++) {
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max + recur(i + 1, jobDifficulty, d - 1, cache));
        }

        return cache[idx][d] = res;
    }
}
