class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        int l = 0;
        int r = n - 1;

        while (l < r && s.charAt(l) == s.charAt(r)) {
            char c = s.charAt(l);

            while (l + 1 < r && s.charAt(l + 1) == c) {
                l++;
            }

            while (r - 1 > l && s.charAt(r - 1) == c) {
                r--;
            }

            l++;
            r--;
        }

        return r - l + 1;
    }
}
