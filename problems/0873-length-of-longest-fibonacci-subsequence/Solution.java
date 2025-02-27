class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = i - 1;

            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    dp[r][i] = Math.max(dp[r][i], dp[l][r] + 1);
                    result = Math.max(result, dp[r][i]);
                    l++;
                } else if (arr[l] + arr[r] < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result == 0 ? 0 : result + 2;
    }
}
