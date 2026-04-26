class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(i, j, -1, -1, grid, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[][] visited) {
        if (grid[r][c] == '*') {
            return true;
        }

        char ch = grid[r][c];
        grid[r][c] = '*';

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr == grid.length || nc == grid[0].length || (nr == pr && nc == pc) || (grid[nr][nc] != '*' && grid[nr][nc] != ch)) {
                continue;
            }

            if (dfs(nr, nc, r, c, grid, visited)) {
                return true;
            }
        }

        visited[r][c] = true;
        grid[r][c] = ch;

        return false;
    }
}
