class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] f = new int[3];
        int result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            f[s.charAt(r) - 'a']++;

            while (f[s.charAt(l) - 'a'] > 1) {
                f[s.charAt(l++) - 'a']--;
            }

            if (f[0] > 0 && f[1] > 0 && f[2] > 0) {
                result += l + 1;
            }
        }

        return result;
    }
}
