class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int close = 0;

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                close = Math.min(open, close + 1);
            }
        }

        open = close;

        int idx = -1;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                chars[++idx] = c;
            } else if (c == '(' && open > 0) {
                chars[++idx] = c;
                open--;
            } else if (c == ')' && open < close) {
                chars[++idx] = c;
                close--;
            }
        }

        return String.valueOf(chars, 0, idx + 1);
    }
}   
