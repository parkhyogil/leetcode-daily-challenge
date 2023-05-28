class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        Arrays.sort(cuts);
        return recur(0, n, 0, m - 1, cuts, new int[m][m]);
    }

    private int recur(int left, int right, int s, int e, int[] cuts, int[][] memo) {
        if (s > e) {
            return 0;
        }

        if (memo[s][e] > 0) {
            return memo[s][e];
        }
        int res = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            res = Math.min(res, (right - left) + recur(left, cuts[i], s, i - 1, cuts, memo) + recur(cuts[i], right, i + 1, e, cuts, memo));
        }
        return memo[s][e] = res;
    }
}
