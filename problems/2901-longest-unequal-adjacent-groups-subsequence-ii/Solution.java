class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;

        int[] next = new int[n];
        int[] size = new int[n];

        int max = n;

        for (int i = n - 1; i >= 0; i--) {
            next[i] = n;
            size[i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] && size[j] + 1 > size[i] && getHammingDistance(words[i], words[j]) == 1) {
                    size[i] = size[j] + 1;
                    next[i] = j;
                }
            }

            if (max == n || size[max] < size[i]) {
                max = i;
            }
        }

        List<String> result = new ArrayList<>();

        while (max != n) {
            result.add(words[max]);
            max = next[max];
        }

        return result;
    }

    private int getHammingDistance(String s, String t) {
        if (s.length() != t.length()) {
            return -1;
        }

        int dist = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                dist++;
            }
        }

        return dist;
    }
}
