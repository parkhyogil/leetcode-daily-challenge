class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int[] idx = new int[n];

        for (int i = 0; i < n; i++) {
            int j = n - 1;

            while (j >= 0 && grid[i][j] == 0) {
                j--;
            }

            idx[i] = j;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int j = i;

            while (j < n && idx[j] > i) {
                j++;
            }

            if (j == n) {
                return -1;
            }

            result += j - i;

            while (j > i) {
                int tmp = idx[j];
                idx[j] = idx[j - 1];
                idx[j - 1] = tmp;
                j--;
            }
        }

        return result;
    }
}
