class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();

        if (n == 0) {
            return "";
        }

        long base = 29;
        long MOD = (long) 1e9 + 7;

        long[] suffixHash = new long[n];
        long[] reverseSuffixHash = new long[n];

        long pow = 29;

        suffixHash[0] = reverseSuffixHash[0] = s.charAt(0) - 'a';

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);

            suffixHash[i] = ((suffixHash[i - 1] * base) % MOD + (c - 'a')) % MOD;
            reverseSuffixHash[i] = (reverseSuffixHash[i - 1] + ((c - 'a') * pow) % MOD) % MOD;
            pow = (pow * base) % MOD;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (suffixHash[i] == reverseSuffixHash[i] && isPalindrome(s, 0, i)) {
                return new StringBuilder().append(s.substring(i + 1)).reverse().append(s).toString();
            }
        }

        return "";
    }

    private boolean isPalindrome(String s, int left, int right) {
         while (left < right) {
             if (s.charAt(left) != s.charAt(right)) {
                 return false;
             }
             left++;
             right--;
         }
        return true;
    }
}
