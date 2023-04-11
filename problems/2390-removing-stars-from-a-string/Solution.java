class Solution {
    public String removeStars(String s) {
        char[] stack = new char[s.length()];
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (idx > 0) {
                    idx--;
                }
            } else {
                stack[idx++] = c;
            }
        }
        return String.valueOf(stack, 0, idx);
    }
}
