class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (true) {
                    int x = grid[i][j] - 1;
                    int y = grid[x / n][x % n] - 1;

                    if (i * n + j == x || x == y) {
                        break;
                    }

                    grid[i][j] = y + 1;
                    grid[x / n][x % n] = x + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i * n + j + 1 != grid[i][j]) {
                    return new int[] {grid[i][j], i * n + j + 1};
                }
            }
        }
        
        return new int[0];
    }
}
