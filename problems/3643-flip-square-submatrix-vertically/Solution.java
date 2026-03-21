class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            for (int j = y; j < y + k; j++) {
                int t = grid[x + i][j];
                grid[x + i][j] = grid[x + k - 1 - i][j];
                grid[x + k - 1 - i][j] = t;
            }
        }
        return grid;
    }
}
