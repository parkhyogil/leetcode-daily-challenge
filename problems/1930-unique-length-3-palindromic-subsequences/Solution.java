class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        int[] suffix = new int[n];
        for (int i = n - 1; i > 0; i--) {
            int d = s.charAt(i) - 'a';
            suffix[i - 1] = suffix[i] | (1 << d);
        }

        boolean[] set = new boolean[26 * 26];
        int prefix = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                if ((prefix & (1 << j)) == 0 || (suffix[i] & (1 << j)) == 0) {
                    continue;
                }

                int subseq = d * 26 + j;
                if (!set[subseq]) {
                    set[subseq] = true;
                    result++;
                }
            }

            prefix |= 1 << d;
        }

        return result;
    }
}
