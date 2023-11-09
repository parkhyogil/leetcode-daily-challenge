class Solution {
    public int countHomogenous(String s) {
        int MOD = (int) 1e9 + 7;

        int res = 0;
        int len = 0;
        char prev = '*';

        for (char c : s.toCharArray()) {
            if (c != prev) {
                prev = c;
                len = 0;
            }
            len++;

            res = (res + len) % MOD;
        }

        return res;
    }
}
