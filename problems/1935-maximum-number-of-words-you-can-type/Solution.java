class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] isBroken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            isBroken[c - 'a'] = true;
        }

        int result = 0;

        for (String s : text.split(" ")) {
            if (canBeTyped(s, isBroken)) {
                result++;
            }
        }

        return result;
    }

    boolean canBeTyped(String s, boolean[] isBroken) {
        for (char c : s.toCharArray()) {
            if (isBroken[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
