class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] count = new int[26];
        int distinctChars = 0;

        int result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            int c = s.charAt(r) - 'a';

            if (count[c] == 0) {
                distinctChars++;
            }
            count[c]++;

            while (distinctChars == 3) {
                result += n - r;

                c = s.charAt(l++) - 'a';
                count[c]--;
                if (count[c] == 0) {
                    distinctChars--;
                }
            }
        }

        return result;
    }
}
