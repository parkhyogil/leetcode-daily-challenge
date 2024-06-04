class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean containOddChar = false;
        int res = 0;

        for (int c : count) {
            res += c / 2 * 2;

            if (c % 2 == 1) {
                containOddChar = true;
            }
        }

        if (containOddChar) {
            res++;
        }

        return res;
    }
}
