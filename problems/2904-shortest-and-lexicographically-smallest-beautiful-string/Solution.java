class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int x = 0;
        int i = -1;
        int j = n;

        for (int l = 0, r = 0; r < n; r++) {
            if (s.charAt(r) == '1') {
                x++;
            }

            while (x > k) {
                if (s.charAt(l) == '1') {
                    x--;
                }
                l++;
            }

            if (x == k) {
                while (s.charAt(l) == '0') {
                    l++;
                }

                if (isSmall(s, l, r, i, j)) {
                    i = l;
                    j = r;
                }
            }
        }

        return i == -1 ? "" : s.substring(i, j + 1);
    }

    boolean isSmall(String s, int l, int r, int i, int j) {
        int d0 = r - l;
        int d1 = j - i;

        if (d0 < d1) {
            return true;
        }
        if (d0 > d1) {
            return false;
        }

        while (l < r) {
            if (s.charAt(l) < s.charAt(i)) {
                return true;
            } else if (s.charAt(l) > s.charAt(i)) {
                return false;
            }
            l++;
            i++;
        }

        return false;
    }
}
