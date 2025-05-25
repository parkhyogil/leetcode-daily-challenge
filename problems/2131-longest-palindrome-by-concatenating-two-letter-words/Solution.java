class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];

        for (String word : words) {
            count[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }

        boolean hasDoubleCharWord = false;
        int result = 0;

        for (int i = 0; i < 26; i++) {
            hasDoubleCharWord |= count[i][i] % 2 == 1;
            result += count[i][i] / 2 * 4;

            for (int j = i + 1; j < 26; j++) {
                result += Math.min(count[i][j], count[j][i]) * 4;
            }
        }

        if (hasDoubleCharWord) {
            result += 2;
        }

        return result;
    }
}
