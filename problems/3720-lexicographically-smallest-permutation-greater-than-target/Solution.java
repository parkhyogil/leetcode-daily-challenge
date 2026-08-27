class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] arr = new char[n];

        return recur(0, freq, arr, target) ? String.valueOf(arr) : "";
    }

    boolean recur(int i, int[] freq, char[] arr, String t) {
        if (i == arr.length) {
            return false;
        }

        char c = t.charAt(i);

        if (freq[c - 'a'] > 0) {
            arr[i] = c;
            freq[c - 'a']--;
            if (recur(i + 1, freq, arr, t)) {
                return true;
            }
            freq[c - 'a']++;
        }
        
        int j = c - 'a' + 1;
        while (j < 26 && freq[j] == 0) {
            j++;
        }

        if (j == 26) {
            return false;
        }

        arr[i++] = (char) ('a' + j);
        freq[j]--;

        j = 0;
        while (i < arr.length) {
            while (j < 26 && freq[j] == 0) {
                j++;
            }
            arr[i++] = (char) ('a' + j);
            freq[j]--;
        }
        return true;
    }
}
