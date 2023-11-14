class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        boolean[][] right = new boolean[n][26];
        boolean[][][] visit = new boolean[26][26][26];

        right[n - 1][s.charAt(n - 1) - 'a'] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                right[i][j] = right[i + 1][j];
            }
            right[i][s.charAt(i) - 'a'] = true;
        }

        int res = 0;

        boolean[] left = new boolean[26];
        left[s.charAt(0) - 'a'] = true;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (left[j] && right[i + 1][j] && !visit[j][s.charAt(i) - 'a'][j]) {
                    res++;
                    visit[j][s.charAt(i) - 'a'][j] = true;
                }
            }

            left[s.charAt(i) - 'a'] = true;
        }
        return res;
    }
}
