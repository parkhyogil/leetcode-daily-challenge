class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        int[] next = new int[n];
        int[] size = new int[n + 1];

        int zero = n;
        int one = n;

        int max = n;

        for (int i = n - 1; i >= 0; i--) {
            if (groups[i] == 0) {
                size[i] = size[one] + 1;
                next[i] = one;
                zero = i;
            } else {
                size[i] = size[zero] + 1;
                next[i] = zero;
                one = i;
            }

            if (size[max] < size[i]) {
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
}
