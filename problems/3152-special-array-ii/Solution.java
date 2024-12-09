class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int m = nums.length;
        int n = queries.length;

        int[] group = new int[m];

        for (int i = 1; i < m; i++) {
            if ((nums[i - 1] + nums[i]) % 2 == 1) {
                group[i] = group[i - 1];
            } else {
                group[i] = group[i - 1] + 1;
            }
        }

        boolean[] result = new boolean[n];

        for (int i = 0; i < n; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            result[i] = group[from] == group[to];
        }

        return result;
    }
}
