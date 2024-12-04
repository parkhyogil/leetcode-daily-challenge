class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        if (m < n) {
            return false;
        }

        int j = 0;

        for (int i = 0; i < m && j < n; i++) {
            int val1 = str1.charAt(i) - 'a';
            int val2 = str2.charAt(j) - 'a';

            if (val1 == val2 || (val1 + 1) % 26 == val2) {
                j++;
            }
        }

        return j == n;
    }
}
