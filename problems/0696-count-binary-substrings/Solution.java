class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();

        int result = 0;
        int prev = 0;
        int count = 1;

        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) != s.charAt(i - 1)) {
                result += Math.min(prev, count);
                prev = count;
                count = 1;
            } else {
                count++;
            }
        }

        return result;
    }
}
