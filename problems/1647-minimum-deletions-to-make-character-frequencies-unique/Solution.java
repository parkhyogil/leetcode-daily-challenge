class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int res = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (!set.contains(count[i])) {
                    set.add(count[i]);
                    break;
                }
                count[i]--;
                res++;
            }
        }
        return res;
    }
}
