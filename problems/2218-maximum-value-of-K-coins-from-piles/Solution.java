class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();

        return recur(0, k, piles, new Integer[n][k + 1]);
    }

    private int recur(int idx, int k, List<List<Integer>> piles, Integer[][] memo) {
        if (k <= 0 || idx == piles.size()) {
            return 0;
        }
        if (memo[idx][k] != null) {
            return memo[idx][k];
        }
        int res = recur(idx + 1, k, piles, memo);
        int sum = 0;
        for (int i = 0; i < piles.get(idx).size() && k - i - 1 >= 0; i++) {
            sum += piles.get(idx).get(i);
            res = Math.max(res, sum + recur(idx + 1, k - i - 1, piles, memo));
        }
        return memo[idx][k] =res;
    }
}
