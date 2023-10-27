class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxL = 0;
        int maxR = 0;

        for (int i = 0; i < n; i++) {
            for (int l = i, r = i; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l > maxR - maxL) {
                    maxR = r;
                    maxL = l;
                }
            }

            for (int l = i, r = i + 1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l > maxR - maxL) {
                    maxR = r;
                    maxL = l;
                }
            }
        }

        return s.substring(maxL, maxR + 1);
    }
}
