class Solution {
    public long countOfSubstrings(String word, int k) {
        int n = word.length();

        int[] count = new int[26];
        int consonants = 0;
        int distinctVowels = 0;

        int left = 0;
        long result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            char c = word.charAt(r);

            if (isVowel(c)) {
                if (count[c - 'a'] == 0) {
                    distinctVowels++;
                }
                count[c - 'a']++;
            } else {
                consonants++;
            }

            while (consonants > k) {
                c = word.charAt(l++);

                if (isVowel(c)) {
                    count[c - 'a']--;
                    if (count[c - 'a'] == 0) {
                        distinctVowels--;
                    }
                } else {
                    consonants--;
                    left = 0;
                }
            }

            while (consonants == k && distinctVowels == 5 && isVowel(word.charAt(l)) && count[word.charAt(l) - 'a'] > 1) {
                count[word.charAt(l++) - 'a']--;
                left++;
            }

            if (consonants == k && distinctVowels == 5) {
                result += left + 1;
            }
        }

        return result;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
