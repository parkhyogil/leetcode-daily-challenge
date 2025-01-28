class Solution {
    private final int[] offset = {-1, 0, 1, 0, -1};

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, catchFish(i, j, grid));
            }
        }

        return result;
    }

    private int catchFish(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        int result = grid[r][c];
        grid[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            result += catchFish(r + offset[i], c + offset[i + 1], grid);
        }

        return result;
    }
}
