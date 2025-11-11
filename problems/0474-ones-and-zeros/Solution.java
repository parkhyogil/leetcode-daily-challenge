class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        dp[0][0] = 0;

        int result = 0;

        for (String s : strs) {
            int one = 0;
            int zero = 0;

            for (char c : s.toCharArray()) {
                if (c == '1') {
                    one++;
                } else {
                    zero++;
                }
            }

            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    if (dp[i - zero][j - one] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }
        }
        
        return result;
    }
}
