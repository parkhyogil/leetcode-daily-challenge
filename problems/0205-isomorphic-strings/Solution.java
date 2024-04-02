class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        char[] S = new char[128];
        char[] T = new char[128];

        for (int i = 0; i < n; i++) {
            S[s.charAt(i)] = t.charAt(i);
            T[t.charAt(i)] = s.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            if (t.charAt(i) != S[s.charAt(i)] || s.charAt(i) != T[t.charAt(i)]) {
                return false;
            }
        }

        return true;
    }
}
