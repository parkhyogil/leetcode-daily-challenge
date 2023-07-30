class Solution {
    public int strangePrinter(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
            }
        }

        s = sb.toString();
        int n = s.length();

        return recur(0, n - 1, s, new int[n][n]);
    }

    private int recur(int left, int right, String s, int[][] memo) {
        if (left == right) {
            return 1;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        if (s.charAt(left) == s.charAt(right)) {
            return memo[left][right] = recur(left + 1, right, s, memo);
        }

        int res = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            res = Math.min(res, recur(left, i, s, memo) + recur(i + 1, right, s, memo));
        }
        return memo[left][right] = res;
    }
}
