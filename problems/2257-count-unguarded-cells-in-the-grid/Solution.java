class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = -1;
        }
        
        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];

            for (int i = r - 1; i >= 0 && grid[i][c] != -1; i--) {
                grid[i][c] = 1;
            }

            for (int i = r + 1; i < m && grid[i][c] != -1; i++) {
                grid[i][c] = 1;
            }

            for (int i = c - 1; i >= 0 && grid[r][i] != -1; i--) {
                grid[r][i] = 1;
            }

            for (int i = c + 1; i < n && grid[r][i] != -1; i++) {
                grid[r][i] = 1;
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
