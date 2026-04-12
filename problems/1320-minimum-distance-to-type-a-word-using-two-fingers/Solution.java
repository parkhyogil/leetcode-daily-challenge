class Solution {
    public int minimumDistance(String word) {
        int[][][] cache = new int[word.length()][27][27];

        for (int[][] a : cache) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return recur(0, -1, -1, word, cache);
    }

    int recur(int i, int l, int r, String s, int[][][] cache) {
        if (i == s.length()) {
            return 0;
        }

        if (cache[i][l + 1][r + 1] != -1) {
            return cache[i][l + 1][r + 1];
        }

        int c = s.charAt(i) - 'A';

        int a = get(l, c) + recur(i + 1, c, r, s, cache);
        int b = get(r, c) + recur(i + 1, l, c, s, cache);

        return cache[i][l + 1][r + 1] = Math.min(a, b);
    }

    int get(int a, int b) {
        if (a == -1) {
            return 0;
        }

        int r0 = a / 6;
        int c0 = a % 6;
        int r1 = b / 6;
        int c1 = b % 6;

        return Math.abs(r0 - r1) + Math.abs(c0 - c1);
    }
}
