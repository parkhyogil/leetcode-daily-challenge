class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] memo = new int[n][k + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        
        return recur(0, -1, events, k, memo);
    }

    private int recur(int idx, int endDay, int[][] events, int k, int[][] memo) {
        if (k == 0 || idx == events.length) {
            return 0;
        }

        if (memo[idx][k] != -1) {
            return memo[idx][k];
        }

        int res = 0;
        for (int i = idx; i < events.length; i++) {
            if (endDay < events[i][0]) {
                res = Math.max(res, events[i][2] + recur(i + 1, events[i][1], events, k - 1, memo));
            }
        }
        return memo[idx][k] = res;
    }
}
