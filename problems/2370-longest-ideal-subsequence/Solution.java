class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();

        int[] count = new int[26];

        int res = 0;
        for (char c : s.toCharArray()) {
            int max = 0;
            for (int i = c - k - 'a'; i <= c + k - 'a'; i++) {
                if (i >= 0 && i < 26 && max < count[i] + 1) {
                    max = count[i] + 1;
                }
            }
            count[c - 'a'] = max;
            res = Math.max(res, max);
        }
        return res;
    }
}
