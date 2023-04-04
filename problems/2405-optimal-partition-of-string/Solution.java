class Solution {
    public int partitionString(String s) {
        int n = s.length();

        int res = 1;
        boolean[] contains = new boolean[128];
        for (int l = 0, r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (contains[c]) {
                while (l < r) {
                    contains[s.charAt(l++)] = false;
                }
                res++;
            }
            contains[c] = true;
        }
        return res;
    }
}
