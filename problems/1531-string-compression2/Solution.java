class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();

        int[][] cache = new int[n][k + 1];

        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return recur(0, s, k, cache);
    }

    private int recur(int idx, String s, int k, int[][] cache) {
        if (k < 0) {
            return 200;
        }

        if (idx + k >= s.length()) {
            return 0;
        }

        if (cache[idx][k] != -1) {
            return cache[idx][k];
        }

        int res = recur(idx + 1, s, k - 1, cache);

        int diff = 0;
        int same = 0;
        int length = 0;

        for (int i = idx; i < s.length() && diff <= k; i++) {
            if (s.charAt(i) == s.charAt(idx)) {
                same++;
                if (same <= 2 || same == 10 || same == 100) {
                    length++;
                }
            } else {
                diff++;
            }

            res = Math.min(res, length + recur(i + 1, s, k - diff, cache));
        }

        return cache[idx][k] = res;
    }
}
