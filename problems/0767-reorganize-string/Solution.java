class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] count = new int[26];
        int maxCount = 0;
        int maxChar = 0;
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;

            if (count[c - 'a'] > maxCount) {
                maxCount = count[c - 'a'];
                maxChar = c - 'a';
            }
        }

        if (maxCount > (n + 1) / 2) {
            return"";
        }

        char[] res = new char[n];
        int idx = 0;

        while (count[maxChar] > 0) {
            res[idx] = (char) (maxChar + 'a');
            idx += 2;
            count[maxChar]--;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (idx >= n) {
                    idx = 1;
                }

                res[idx] = (char) (i + 'a');
                idx += 2;
                count[i]--;
            }
        }
        return String.valueOf(res);
    }
}
