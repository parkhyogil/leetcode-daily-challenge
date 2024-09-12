class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedChar = checkAllowedChar(allowed);

        int result = 0;
        
        for (String word : words) {
            if (isConsistentString(word, allowedChar)) {
                result++;
            }
        }

        return result;
    }

    private boolean[] checkAllowedChar(String s) {
        boolean[] allowedChar = new boolean[26];

        for (char c : s.toCharArray()) {
            allowedChar[c - 'a'] = true;
        }

        return allowedChar;
    }

    private boolean isConsistentString(String word, boolean[] allowedChar) {
        for (char c : word.toCharArray()) {
            if (!allowedChar[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
