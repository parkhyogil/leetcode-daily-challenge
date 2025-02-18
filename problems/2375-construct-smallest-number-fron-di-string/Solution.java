class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();

        char[] chars = new char[n + 1];
        boolean[] used = new boolean[10];

        for (int i = 1; i <= 9; i++) {
            chars[0] = (char) ('0' + i);
            used[i] = true;
            if (backtracking(0, i, pattern, chars, used)) {
                return String.valueOf(chars);
            }
            used[i] = false;
        }

        return "";
    }

    boolean backtracking(int idx, int prev, String pattern, char[] chars, boolean[] used) {
        if (idx == pattern.length()) {
            return true;
        }

        char p = pattern.charAt(idx);
        
        for (int i = 1; i <= 9; i++) {
            if (used[i] || (p == 'I' && prev >= i) || (p == 'D' && prev <= i)) {
                continue;
            }

            used[i] = true;
            chars[idx + 1] = (char) ('0' + i);

            if (backtracking(idx + 1, i, pattern, chars, used)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}
