class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (m < n) {
            return -1;
        }

        int[] LPS = new int[n];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            while (idx > 0 && needle.charAt(i) != needle.charAt(idx)) {
                idx = LPS[idx - 1];
            }
            if (needle.charAt(i) == needle.charAt(idx)) {
                idx++;
            }
            LPS[i] = idx;
        }

        idx = 0;
        for (int i = 0; i < m; i++) {
            while (idx > 0 && haystack.charAt(i) != needle.charAt(idx)) {
                idx = LPS[idx - 1];
            }
            if (haystack.charAt(i) == needle.charAt(idx)) {
                idx++;
                if (idx == n) {
                    return i - n + 1;
                }
            }
        }
        return -1;
    }
}
