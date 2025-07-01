class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();

        int result = 1;

        for (int l = 0, r = 0; r <= n; r++) {
            if (r == n || word.charAt(l) != word.charAt(r)) {
                result += r - l - 1;
                l = r;
            }
        }

        return result;
    }
}
