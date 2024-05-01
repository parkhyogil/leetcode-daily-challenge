class Solution {
    public String reversePrefix(String word, char ch) {
        int chIdx = getFirstIdxOf(word, ch);

        if (chIdx == -1) {
            return word;
        }

        char[] chars = word.toCharArray();

        for (int i = 0, j = chIdx; i < j; i++, j--) {
            swap(i, j, chars);
        }

        return String.valueOf(chars);
    }

    private int getFirstIdxOf(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int i, int j, char[] chars) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
