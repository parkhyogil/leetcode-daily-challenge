class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[126];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] used = new boolean[126];
        char[] stack = new char[26];
        int idx = -1;
        for (char c : s.toCharArray()) {
            count[c]--;

            if (used[c]) {
                continue;
            }

            while (idx >= 0 && stack[idx] >= c && count[stack[idx]] > 0) {
                used[stack[idx--]] = false;
            }

            stack[++idx] = c;
            used[c] = true;
        }

        return String.valueOf(stack, 0, idx + 1);
    }
}
