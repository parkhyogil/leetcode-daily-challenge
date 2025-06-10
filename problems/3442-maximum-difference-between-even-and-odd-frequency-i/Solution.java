class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int a1 = 0;
        int a2 = 101;

        for (int f : freq) {
            if (f == 0) {
                continue;
            }

            if (f % 2 == 0) {
                a2 = Math.min(a2, f);
            } else {
                a1 = Math.max(a1, f);
            }
        }

        return a1 - a2;
    }
}
