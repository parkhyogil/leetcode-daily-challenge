class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        char[] chars = new char[n];
        int[] freq = new int[128];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                freq[c]++;
                chars[i] = '*';
            } else {
                chars[i] = c;
            }
        }

        for (int i = 0, j = 0; i < n; i++) {
            if (chars[i] != '*') {
                continue;
            }

            while (freq[j] == 0) {
                j++;
            }

            chars[i] = (char) j;
            freq[j]--;
        }

        return String.valueOf(chars);
    }
}
