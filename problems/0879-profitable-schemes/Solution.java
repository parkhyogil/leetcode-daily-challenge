class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] memo = new int[101][101][101];
        for (int[][] i : memo) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return recur(0, 0, n, minProfit, group, profit, memo);
    }

    private int recur(int idx, int sum, int n, int min, int[] group, int[] profit, int[][][] memo) {
        if (n < 0) {
            return 0;
        }
        if (idx == group.length) {
            return sum >= min ? 1 : 0;
        }
        if (memo[idx][n][sum] != -1) {
            return memo[idx][n][sum];
        }
        return memo[idx][n][sum] = (recur(idx + 1, sum, n, min, group, profit, memo) % MOD + 
                            recur(idx + 1, Math.min(sum + profit[idx], min), n - group[idx], min, group, profit, memo) % MOD) % MOD;
    }
}
