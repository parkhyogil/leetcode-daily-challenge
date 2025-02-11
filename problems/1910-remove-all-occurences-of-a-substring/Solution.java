class Solution {
    public String removeOccurrences(String s, String part) {
        int partLength = part.length();

        int idx = -1;
        char[] chars = s.toCharArray();

        for (char c : chars) {
            chars[++idx] = c;

            if (isOccurence(chars, idx, part, partLength)) {
                idx -= partLength;
            }
        }

        return String.valueOf(chars, 0, idx + 1);
    }

    boolean isOccurence(char[] chars, int lastIndex, String s, int n) {
        if (lastIndex - n + 1 < 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (chars[lastIndex - i] != s.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
