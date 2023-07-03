class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < n; i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        } else {
            int i = -1;
            int j = -1;
            for (int k = 0; k < n; k++) {
                if (s.charAt(k) != goal.charAt(k)) {
                    if (i == -1) {
                        i = k;
                    } else if (j == -1) {
                        j = k;
                    } else {
                        return false;
                    }
                }
            }
            return i != -1 && j != -1 && s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }
    }
}
