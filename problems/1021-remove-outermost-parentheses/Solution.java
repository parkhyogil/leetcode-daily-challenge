class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        int b = 0;
        int l = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                if (b == 0) {
                    l = i;
                }
                
                b++;
            } else {
                b--;

                if (b == 0) {
                    sb.append(s.substring(l + 1, i));
                }
            }
        }

        return sb.toString();
    }
}
