class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] charFrequency = new int[26];
        
        for (char c : s1.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        for (int l = 0, r = 0; r < n; r++) {
            int charIdx = s2.charAt(r) - 'a';
            charFrequency[charIdx]--;

            while (charFrequency[charIdx] < 0) {
                charFrequency[s2.charAt(l++) - 'a']++;
            }

            if (r - l + 1 == m) {
                return true;
            }
        }

        return false;
    }
}
