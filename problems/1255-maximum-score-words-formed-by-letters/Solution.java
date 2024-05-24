class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;

        int[] count = new int[26];
        for (char letter : letters) {
            count[letter - 'a']++;
        }

        int[] scoreOf = new int[n];
        for (int i = 0; i < n; i++) {
            scoreOf[i] = getScore(words[i], score);
        }

        return recur(0, words, count, scoreOf);
    }

    private int recur(int idx, String[] words, int[] count, int[] scoreOf) {
        if (idx == words.length) {
            return 0;
        }

        int res = recur(idx + 1, words, count, scoreOf);

        String word = words[idx];

        boolean canForm = true;
        for (char c : word.toCharArray()) {
            count[c - 'a']--;

            if (count[c - 'a'] < 0) {
                canForm = false;
            }
        }

        if (canForm) {
            res = Math.max(res, scoreOf[idx] + recur(idx + 1, words, count, scoreOf));
        }

        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        return res;
    }

    private int getScore(String word, int[] score) {
        int res = 0;

        for (char c : word.toCharArray()) {
            res += score[c - 'a'];
        }

        return res;
    }
}
