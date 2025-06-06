class Solution {
    public String robotWithString(String s) {
        int n = s.length();

        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        int[] maxRequiredIndex = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (lastIndex[c] == -1) {
                lastIndex[c] = i;
            }

            for (int j = 0; j < c; j++) {
                maxRequiredIndex[i] = Math.max(maxRequiredIndex[i], lastIndex[j]);
            }
        }

        int[] stack = new int[n];
        int idx = -1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stack[++idx] = i;

            while (idx > -1 && maxRequiredIndex[stack[idx]] <= i) {
                sb.append(s.charAt(stack[idx--]));
            }
        }

        return sb.toString();
    }
}
