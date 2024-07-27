class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n + 1];
        int diff = recur(0, 1, piles, memo);
        
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        return (sum + diff) / 2;
    }
    
    public int recur(int i, int m, int[] nums, Integer[][] memo) {
        if (i >= memo.length) {
            return 0;
        }
        if (memo[i][m] == null) {
            int res = Integer.MIN_VALUE;
            int sum = 0;
            for (int x = 0; x < m * 2; x++) {
                if (i + x < nums.length) {
                    sum += nums[i + x];
                    res = Math.max(res, sum - recur(i + x + 1, Math.max(m, x + 1), nums, memo));
                }
            }
            memo[i][m] = res;
        }
        return memo[i][m];
    }
}
