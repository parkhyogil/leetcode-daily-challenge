class Solution {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder sb = new StringBuilder(m + n);
        int idx = 0;

        for (int i = 0; i < m; i++) {
            if (idx < n && spaces[idx] == i) {
                sb.append(' ');
                idx++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
