class Solution {
    private int idx;

    public String reverseParentheses(String s) {
        idx = 0;

        return recur(s);
    }

    private String recur(String s) {
        StringBuilder sb = new StringBuilder();

        while (idx < s.length()) {
            char c = s.charAt(idx++);

            if (c == '(') {
                sb.append(recur(s));
            } else if (c == ')') {
                return sb.reverse().toString();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
