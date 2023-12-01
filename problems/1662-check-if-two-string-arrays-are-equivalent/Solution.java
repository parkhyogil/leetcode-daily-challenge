class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int m = word1.length;
        int n = word2.length;

        int s1 = 0;
        int s2 = 0;

        int idx1 = 0;
        int idx2 = 0;

        while (s1 < m && s2 < n) {
            if (word1[s1].charAt(idx1++) != word2[s2].charAt(idx2++)) {
                return false;
            }

            if (idx1 == word1[s1].length()) {
                idx1 = 0;
                s1++;
            }

            if (idx2 == word2[s2].length()) {
                idx2 = 0;
                s2++;
            }
        }

        return s1 == m && s2 == n;
    }
}
