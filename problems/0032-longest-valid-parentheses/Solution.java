class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        char[] arr = s.toCharArray();

        int[] st = new int[n + 1];
        int j = -1;

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == ')' && j > -1 && arr[st[j]] == '(') {
                j--;
                result = Math.max(result, i - (j >= 0 ? st[j] : -1));
                continue;
            }

            st[++j] = i;
        }

        return result;
    }
}
