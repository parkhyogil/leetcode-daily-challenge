class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int len = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (isVowel(s.charAt(r))) {
                len++;
            }

            if (r - l + 1 > k && isVowel(s.charAt(l++))) {
                len--;
            }

            res = Math.max(res, len);
        }
        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
