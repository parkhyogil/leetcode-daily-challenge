class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    result++;
                }
            }
        }

        return result;
    }

    boolean isPrefixAndSuffix(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i) || s1.charAt(i) != s2.charAt(m - n + i)) {
                return false;
            }
        }

        return true;
    }
