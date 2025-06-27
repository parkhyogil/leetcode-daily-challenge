class Solution {
    private String result;

    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();

        result = "";

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            freq[i] = freq[i] / k;
        }

        backtracking(0, k, freq, new char[n / k], s);

        return result;
    }

    private void backtracking(int idx, int k, int[] freq, char[] chars, String s) {
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                continue;
            }

            chars[idx] = (char) ('a' + i);
            freq[i]--;

            backtracking(idx + 1, k, freq, chars, s);


            freq[i]++;
        }

        if (idx > result.length() && isValid(idx, k, chars, s)) {
            result = String.valueOf(chars, 0, idx);
        }
    }

    private boolean isValid(int len, int k, char[] chars, String s) {
        int i = 0, j = 0;

        while (j < s.length()) {
            if (chars[i % len] == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return (i / len) >= k;
    }
}
