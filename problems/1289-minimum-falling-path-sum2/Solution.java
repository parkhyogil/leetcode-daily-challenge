class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        if (n == 1) {
            return grid[0][0];
        }

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int firstMin = -1;
            int secondMin = -1;
            for (int j = 0; j < n; j++) {
                if (firstMin == -1 || prev[firstMin] > prev[j]) {
                    secondMin = firstMin;
                    firstMin = j;
                } else if (secondMin == -1 || prev[secondMin] > prev[j]) {
                    secondMin = j;
                }
            }

            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (j != firstMin) {
                    curr[j] = grid[i][j] + prev[firstMin];
                } else {
                    curr[j] = grid[i][j] + prev[secondMin];
                }
            }
            prev = curr;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, prev[i]);
        }
        return res;
    }
}
