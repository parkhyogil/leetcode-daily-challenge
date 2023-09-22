class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        int i = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(i) == c) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
