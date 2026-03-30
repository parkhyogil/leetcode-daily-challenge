class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();

        int[] oddF = new int[26];
        int[] evenF = new int[26];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenF[s1.charAt(i) - 'a']++;
                evenF[s2.charAt(i) - 'a']--;
            } else {
                oddF[s1.charAt(i) - 'a']++;
                oddF[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (oddF[i] != 0 || evenF[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
