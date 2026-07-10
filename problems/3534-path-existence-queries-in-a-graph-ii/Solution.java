class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        boolean[] contains = new boolean[max + 1];

        for (int x : nums) {
            contains[x] = true;
        }

        int h = Math.max(0, 31 - Integer.numberOfLeadingZeros(max));

        int[][] t = new int[h + 1][max + 1];
        Arrays.fill(t[0], -1);

        for (int i = 0, j = 0, x = -1; i <= max; i++) {
            if (!contains[i]) {
                continue;
            }

            while (j <= max && j - i <= maxDiff) {
                if (contains[j]) {
                    x = j;
                }
                j++;
            }

            t[0][i] = x;
        }

        for (int i = 1; i <= h; i++) {
            Arrays.fill(t[i], -1);

            for (int j = 0; j + (1 << (i - 1)) <= max; j++) {
                if (t[i - 1][j] != -1) {
                    t[i][j] = t[i - 1][t[i - 1][j]];
                }
            }
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];

            if (u == v) {
                result[i] = 0;
                continue;
            }

            int a = Math.min(nums[u], nums[v]);
            int b = Math.max(nums[u], nums[v]);

            if (a == b) {
                result[i] = 1;
                continue;
            }

            int sum = 0;

            for (int j = h; j >= 0; j--) {
                if (t[j][a] != -1 && t[j][a] < b) {
                    a = t[j][a];
                    sum += 1 << j;
                }
            }

            if (t[0][a] >= b) {
                result[i] = sum + 1;
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}
