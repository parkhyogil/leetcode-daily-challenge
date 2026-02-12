class Solution {
    public int longestBalanced(String s) {
        int n = s.length();

        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int numDistinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';

                if (freq[c] == 0) {
                    numDistinct++;
                }
                freq[c]++;
                maxFreq = Math.max(maxFreq, freq[c]);

                int len = j - i + 1;

                if (len == maxFreq * numDistinct) {
                    result = Math.max(result, len);
                }
            }
        }

        return result;
    }
}
