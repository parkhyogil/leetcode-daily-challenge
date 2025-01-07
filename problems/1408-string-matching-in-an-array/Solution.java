class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && KMP(words[j], words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    boolean KMP(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] lps = computeLPSArray(m, t);
        
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != t.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == t.charAt(j)) {
                j++;
                if (j == m) {
                    return true;
                }
            }
        }

        return false;
    }

    int[] computeLPSArray(int n, String s) {
        int[] result = new int[n];

        int j = 0;
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = result[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
                result[i] = j;
            }
        }

        return result;
    }
}
