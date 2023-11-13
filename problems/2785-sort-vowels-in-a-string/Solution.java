class Solution {
    private final char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

    public String sortVowels(String s) {
        int n = s.length();

        char[] res = s.toCharArray();
        int[] vowelCount = countVowels(s);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (isVowel(c)) {
                while (vowelCount[idx] == 0) {
                    idx++;
                }

                res[i] = vowels[idx];
                vowelCount[idx]--;
            }
        }

        return String.valueOf(res);
    }

    private int[] countVowels(String s) {
        int[] res = new int[10];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isVowel(c)) {
                res[getIdx(c)]++;
            }
        }
        return res;
    }

    private int getIdx(char c) {
        for (int i = 0; i < 10; i++) {
            if (vowels[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private boolean isVowel(char c) {
        for (char vowel : vowels) {
            if (vowel == c) {
                return true;
            }
        }
        return false;
    }
}
