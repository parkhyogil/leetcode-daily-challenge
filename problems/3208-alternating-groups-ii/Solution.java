class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;

        int result = 0;
        int prev = colors[0];

        for (int begin = 0, end = 1; end < n - 1 + k; end++) {
            if (colors[end % n] == prev) {
                begin = end;
            }

            prev = colors[end % n];

            if (end - begin + 1 == k) {
                result++;
                begin++;
            }
        }

        return result;
    }
}
