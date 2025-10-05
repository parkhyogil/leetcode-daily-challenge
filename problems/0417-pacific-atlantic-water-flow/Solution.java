class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, -1, heights, p);
            dfs(i, n - 1, -1, heights, a);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, -1, heights, p);
            dfs(m - 1, i, -1, heights, a);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    void dfs(int r, int c, int prev, int[][] grid, boolean[][] visited) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || visited[r][c] || prev > grid[r][c]) {
            return;
        }

        visited[r][c] = true;
        int h = grid[r][c];

        dfs(r - 1, c,  h, grid, visited);
        dfs(r + 1, c,  h, grid, visited);
        dfs(r, c - 1,  h, grid, visited);
        dfs(r, c + 1,  h, grid, visited);
    }
}
