class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] count = new int[10001];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        int result = 0;

        int i = 1;
        int j = 10000;

        while (j - i >= x) {
            if (count[i] <= count[j]) {
                count[i + x] += count[i];
                result += count[i];
                i++;
            } else {
                count[j - x] += count[j];
                result += count[j];
                j--;
            }
        }

        while (i <= j) {
            if (count[i++] == m * n) {
                return result;
            }
        }

        return -1;
    }
}
