class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;

        int[] id = new int[n];

        for (int i = 1; i < n; i++) {
            id[i] = id[i - 1];
            if (nums[i] - nums[i - 1] > maxDiff) {
                id[i]++;
            }
        }

        boolean[] result = new boolean[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];

            result[i] = id[u] == id[v];
        }

        return result;
    }
}
