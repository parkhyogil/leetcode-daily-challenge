class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();

        int result = 0;
        int[] freq = new int[26];

        for (int l = 0, r = 0; r < n; r++) {
            freq[s.charAt(r) - 'a']++;

            while (freq[s.charAt(r) - 'a'] > 2) {
                freq[s.charAt(l++) - 'a']--;
            }

            result = Math.max(result, r - l + 1);
        }
        
        return result;
    }
}
