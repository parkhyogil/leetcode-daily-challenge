class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        computeDpTable(m, n, str1, str2, dp);
        
        return buildSupersequence(m, n, str1, str2, dp);
    }

    private void computeDpTable(int m, int n, String str1, String str2, int[][] dp) {
        for (int i = 0; i < m; i++) {
            dp[i][n] = m - i;
        }

        for (int i = 0; i < n; i++) {
            dp[m][i] = n - i;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }
    }

    private String buildSupersequence(int m, int n, String str1, String str2, int[][] dp) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else {
                if (dp[i + 1][j] < dp[i][j + 1]) {
                    sb.append(str1.charAt(i++));
                } else {
                    sb.append(str2.charAt(j++));
                }
            }
        }

        if (i < m) {
            sb.append(str1, i, m);
        } else if (j < n) {
            sb.append(str2, j, n);
        }

        return sb.toString();
    }
}
