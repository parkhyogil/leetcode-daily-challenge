class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;

        int INF = 100000000;

        int[][] c = new int[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                c[i][j] = i == j ? 0 : INF;
            }
        }

        for (int i = 0; i < m; i++) {
            c[original[i] - 'a'][changed[i] - 'a'] = Math.min(c[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    c[i][j] = Math.min(c[i][j], c[i][k] + c[k][j]);
                }
            }
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            int a = source.charAt(i) - 'a';
            int b = target.charAt(i) - 'a';

            if (c[a][b] >= INF) {
                return -1;
            }

            result += c[a][b];
        }

        return result;
    }
}
