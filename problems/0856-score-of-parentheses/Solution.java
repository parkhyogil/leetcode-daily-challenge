class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int[] a = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                j++;
            } else {
                if (arr[i - 1] == '(') {
                    a[j - 1] += 1;
                } else {
                    a[j - 1] += a[j] * 2;
                }
                a[j--] = 0;
            }
        }

        return a[0];
    }
}
