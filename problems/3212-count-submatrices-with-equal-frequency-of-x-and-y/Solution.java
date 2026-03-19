class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] freq = new int[n + 1];
        boolean[] containsX = new boolean[n + 1];
        int result = 0;

        for (int i = 0; i < m; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int val = grid[i][j] == 'X' ? 1 : (grid[i][j] == 'Y' ? -1 : 0);
                containsX[j + 1] |= containsX[j] | grid[i][j] == 'X';

                freq[j + 1] += val;

                sum += freq[j + 1];

                if (sum == 0 && containsX[j + 1]) {
                    result++;
                }
            }
        }

        return result;
    }
}
