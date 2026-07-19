class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        boolean[] contains = new boolean[26];
        char[] arr = new char[n];
        int i = -1;

        for (char c : s.toCharArray()) {
            if (contains[c - 'a']) {
                freq[c - 'a']--;
                continue;
            }

            while (i >= 0 && arr[i] >= c && freq[arr[i] - 'a'] > 1) {
                contains[arr[i] - 'a'] = false;
                freq[arr[i] - 'a']--;
                i--;
            }

            contains[c - 'a'] = true;
            arr[++i] = c;
        }

        return String.valueOf(arr, 0, i + 1);
    }
}
