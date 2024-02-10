class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int res = 0;

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }

        return res;
    }
}
