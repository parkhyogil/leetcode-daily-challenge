class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        int[] freq = new int[26];

        char[] arr = s.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0, j = 0; i < n / 2; i++) {
            while (freq[j] == 0) {
                j++;
            }

            arr[i] = arr[n - 1 - i] = (char) ('a' + j);
            freq[j]--;
        }

        return String.valueOf(arr);
    }
}
