class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        return recur(0, 0, stones, new int[n][n]);
    }

    private boolean recur(int idx, int k, int [] stones, int[][] memo) {
        if (idx == stones.length - 1) {
            return true;
        }

        if (memo[idx][k] != 0) {
            return memo[idx][k] == 1;
        }

        boolean res = false;

        for (int i = idx + 1; !res && i < stones.length && stones[i] <= stones[idx] + k + 1; i++) {
            res |= stones[i] == stones[idx] + k - 1 && recur(i, k - 1, stones, memo);
            res |= stones[i] == stones[idx] + k && recur(i, k, stones, memo);
            res |= stones[i] == stones[idx] + k + 1 && recur(i, k + 1, stones, memo);
        }
        
        memo[idx][k] = res ? 1 : -1;
        return res;
    }
}
