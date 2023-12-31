class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();

        int[] idx = new int[26];

        int res = -1;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (idx[c] == 0) {
                idx[c] = i + 1;
            } else {
                res = Math.max(res, i - idx[c]);                
            }   
        }
        return res;
    }
}
