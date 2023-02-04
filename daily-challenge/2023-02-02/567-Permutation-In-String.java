class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] need = new int[26];
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int[] have = new int[26];
        for (int left = 0, right = 0; right < n; right++) {
            char c = s2.charAt(right);

            have[c - 'a']++;
            while (have[c - 'a'] > need[c - 'a']) {
                have[s2.charAt(left++) - 'a']--;
            }

            if (right - left + 1 == m) {
                return true;
            }
        }
        return false;
    }
}
