class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    private int dfs(int id, int[] manager, int[] informTime) {
        if (manager[id] == -1) {
            return informTime[id];
        }
        informTime[id] += dfs(manager[id], manager, informTime);
        manager[id] = -1;
        return informTime[id];
    }
}
