class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int count = dfs(i, j, grid);

                if (count > 1) {
                    result += count;
                }                
            }
        }

        return result;
    }

    int dfs(int i, int j, int[][] grid) {
        grid[i][j] = 0;

        int result = 1;

        for (int k = 0; k < grid.length; k++) {
            if (grid[k][j] > 0) {
                result += dfs(k, j, grid);
            }
        }

        for (int k = 0; k < grid[0].length; k++) {
            if (grid[i][k] > 0) {
                result += dfs(i, k, grid);
            }
        }

        return result;
    }
}
