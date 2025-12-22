class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();

        int result = m;

        int[] dp = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (isSorted(j, i, strs)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.min(result, m - dp[i]);
        }

        return result;
    }

    boolean isSorted(int i, int j, String[] strs) {
        for (String s : strs) {
            if (s.charAt(i) > s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
