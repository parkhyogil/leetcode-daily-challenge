class Solution {
    public int minLength(String s) {
        int n = s.length();

        char[] stack = new char[n];
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
