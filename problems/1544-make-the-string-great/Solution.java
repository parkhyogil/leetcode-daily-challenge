class Solution {
    public String makeGood(String s) {
        char[] stack = new char[s.length()];
        int idx = -1;

        for (char c : s.toCharArray()) {
            if (idx >= 0 && stack[idx] != c && Character.toLowerCase(stack[idx]) == Character.toLowerCase(c)) {
                idx--;
            } else {
                stack[++idx] = c;
            }
        }

        return String.valueOf(stack, 0, idx + 1);
    }
}
