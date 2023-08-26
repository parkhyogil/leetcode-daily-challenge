class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] dp = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
