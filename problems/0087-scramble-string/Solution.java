class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        return recur(s1, s2, new HashMap<>());
    }

    private boolean recur(String s1, String s2, Map<String, Boolean> memo) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() <= 1) {
            return false;
        }
        
        String key = s1 + "/" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int n = s1.length();

        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        boolean res = false;
        for (int i = 1; i < n && !res; i++) {
            boolean swap = recur(s1.substring(0, i), s2.substring(n - i), memo) && recur(s1.substring(i), s2.substring(0, n - i), memo);
            boolean unswap = recur(s1.substring(0, i), s2.substring(0, i), memo) && recur(s1.substring(i), s2.substring(i), memo);
            res = swap || unswap;
        }
        memo.put(key, res);
        return res;
    }
}
