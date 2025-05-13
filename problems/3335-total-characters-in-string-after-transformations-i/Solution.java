class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        int MOD = (int) 1e9 + 7;

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int begin = 0;
        for (int i = 0; i < t; i++) {
            freq[begin] = (freq[begin] + freq[(begin + 25) % 26]) % MOD;

            begin = (26 + begin - 1) % 26;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + freq[i]) % MOD;
        }

        return result;
    }
}
