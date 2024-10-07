class Solution {
    public int minLength(String s) {
        char[] stack = new char[s.length()];
        int idx = -1;

        for (char c : s.toCharArray()) {
            if (idx > -1 && ((stack[idx] == 'A' && c == 'B') || (stack[idx] == 'C' && c == 'D'))) {
                idx--;
            } else {
                stack[++idx] = c;
            }
        }

        return idx + 1;
    }
}
