class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int[] have = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int left = 0, right = 0; right < m; right++) {
            char c = s.charAt(right);
            have[c - 'a']++;

            while (have[c - 'a'] > need[c - 'a']) {
                have[s.charAt(left++) - 'a']--;
            }

            if (right - left + 1 == n) {
                res.add(left);
            }
        }
        return res;
    }
}
