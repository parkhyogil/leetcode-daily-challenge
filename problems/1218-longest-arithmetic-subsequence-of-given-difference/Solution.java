class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[20001];

        int res = 0;

        for (int a : arr) {
            int num = a + 10000;

            dp[num] = (0 <= num - difference && num - difference <= 20000 ? dp[num - difference] : 0) + 1;

            res = Math.max(res, dp[num]);
        }

        return res;
    }
}
