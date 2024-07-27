class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] memo = new int[amount + 1][n];
        
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return recur(0, amount, coins, memo);
    }

    private int recur(int idx, int amount, int[] coins, int[][] memo) {
        if (amount < 0 || idx == coins.length) {
            return 0;    
        }

        if (amount == 0) {
            return 1;
        }

        if (memo[amount][idx] != -1) {
            return memo[amount][idx];
        }

        return memo[amount][idx] = recur(idx, amount - coins[idx], coins, memo) + recur(idx + 1, amount, coins, memo);
    }
}
