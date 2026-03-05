class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int result = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';

            if ((i % 2 == 0 && c == 0) || (i % 2 == 1 && c == 1)) {
                result++;
            }
        }

        return Math.min(result, n - result);
    }
}
