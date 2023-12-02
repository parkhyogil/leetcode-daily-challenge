class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsCount = countChars(chars);

        int res = 0;

        for (String word : words) {
            if (isGoodString(word, charsCount)) {
                res += word.length();
            }
        }

        return res;
    }

    private boolean isGoodString(String word, int[] have) {
        int[] need = countChars(word);

        for (int i = 0; i < 26; i++) {
            if (need[i] > have[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] countChars(String word) {
        int[] res = new int[26];
        for (char c : word.toCharArray()) {
            res[c - 'a']++;
        }
        return res;
    }
}
