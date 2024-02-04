class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        int[] need = new int[126];
        int[] have = new int[126];
        int needChar = 0;
        int haveChar = 0;

        for (char c : t.toCharArray()) {
            if (need[c] == 0) {
                needChar++;
            }
            need[c]++;
        }

        int begin = 0;
        int end = -1;

        for (int l = 0, r = 0; r < m; r++) {
            char rC = s.charAt(r);

            have[rC]++;
            if (have[rC] == need[rC]) {
                haveChar++;
            }

            while (haveChar == needChar) {
                if (end == -1 || end - begin > r - l) {
                    begin = l;
                    end = r;
                }

                char lC = s.charAt(l);                

                if (have[lC] == need[lC]) {
                    haveChar--;
                }
                have[lC]--;
                l++;
            }
        }

        return s.substring(begin, end + 1);
    }
}
