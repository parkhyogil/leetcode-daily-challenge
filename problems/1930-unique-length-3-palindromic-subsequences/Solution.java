class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];

        Arrays.fill(firstIndex, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (firstIndex[c] == -1) {
                firstIndex[c] = i;
            }            
            lastIndex[c] = i;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            if (firstIndex[i] == -1) {
                continue;
            }
            
            boolean[] visited = new boolean[26];

            for (int j = firstIndex[i] + 1; j < lastIndex[i]; j++) {
                int c = s.charAt(j) - 'a';

                if (!visited[c]) {
                    visited[c] = true;
                    result++;
                }
            }
        }

        return result;
    }
}
