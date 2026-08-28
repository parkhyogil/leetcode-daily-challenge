class Solution {
    int n;
    int[] freq;
    String t;

    public String lexPalindromicPermutation(String s, String target) {
        n = s.length();
        this.t = target;

        freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                if (odd > -1) {
                    return "";
                }
                odd = i;
            }
        }

        if (n % 2 == 0 && odd > -1) {
            return "";
        }

        char[] arr = new char[n];

        if (n % 2 == 1) {
            arr[n / 2] = (char) ('a' + odd);
            freq[odd]--;
        }

        return recur(0, arr) ? String.valueOf(arr) : "";
    }

    boolean recur(int i, char[] arr) {
        if (i == n / 2) {
            for (int j = i; j < n; j++) {
                if (arr[j] > t.charAt(j)) {
                    return true;
                } else if (arr[j] < t.charAt(j)) {
                    return false;
                }
            }
            return false;
        }

        char c = t.charAt(i);

        if (freq[c - 'a'] > 1) {
            freq[c - 'a'] -= 2;
            arr[i] = arr[n - 1 - i] = c;

            if (recur(i + 1, arr)) {
                return true;
            }

            freq[c - 'a'] += 2;
        }

        int j = c - 'a' + 1;
        while (j < 26 && freq[j] < 2) {
            j++;
        }

        if (j == 26) {
            return false;
        }

        arr[i] = arr[n - 1 - i] = (char) ('a' + j);
        freq[j] -= 2;
        i++;

        j = 0;
        while (i < n / 2) {
            while (j < 26 && freq[j] < 2) {
                j++;
            }

            if (j == 26) {
                return false;
            }
            
            arr[i] = arr[n - 1 - i] = (char) ('a' + j);
            freq[j] -= 2;
            i++;
        }

        return true;
    }
}
