class Solution {
    public int scoreOfString(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return res;
    }
}
