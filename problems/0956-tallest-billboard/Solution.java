class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        Map<Integer, Integer>[] memo = new HashMap[n];
        for (int i = 0; i < n; i++) {
            memo[i] = new HashMap<>();
        }

        return recur(0, 0, rods, memo);
    }

    private int recur(int idx, int sum, int[] rods, Map<Integer, Integer>[] memo) {
        if (idx == rods.length) {
            return sum == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (memo[idx].containsKey(sum)) {
            return memo[idx].get(sum);
        }

        int res = Math.max(recur(idx + 1, sum, rods, memo), 
                    Math.max(recur(idx + 1, sum + rods[idx], rods, memo) + rods[idx], recur(idx + 1, sum - rods[idx], rods, memo)));
        memo[idx].put(sum, res);
        return res;
    }
}
