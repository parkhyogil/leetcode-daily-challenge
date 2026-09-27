class Solution {
    String s;
    int i, n;

    public String reverseParentheses(String s) {
        this.s = s;
        i = 0;
        n = s.length();

        return recur();    
    }

    String recur() {
        StringBuilder sb = new StringBuilder();

        while (i < n) {
            char c = s.charAt(i++);

            if (c == '(') {
                sb.append(recur());        
            } else if (c == ')') {
                return sb.reverse().toString();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
