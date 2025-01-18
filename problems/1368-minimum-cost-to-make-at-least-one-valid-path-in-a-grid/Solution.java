class Solution {
    private int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        boolean[][] added = new boolean[m][n];

        queue.offer(new int[] {0, 0});

        int cost = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                
                movePath(row, col, grid, queue, visited);
            }

            if (visited[m - 1][n - 1]) {
                return cost;
            }

            size = queue.size();

            for (int i = 0; i < size; i++) {
                addAdjacentCell(queue.poll(), queue, visited, added);
            }

            cost++;
        }

        return cost;
    }

    private void addAdjacentCell(int[] cell, Queue<int[]> queue, boolean[][] visited, boolean[][] added) {
        for (int[] d : dir) {
            int nr = cell[0] + d[0];
            int nc = cell[1] + d[1];

            if (isOutOfBoundary(nr, nc, visited.length, visited[0].length) || visited[nr][nc] || added[nr][nc]) {
                continue;
            }

            added[nr][nc] = true;
            queue.offer(new int[] {nr, nc});
        }
    }

    private void movePath(int row, int col, int[][] grid, Queue<int[]> queue, boolean[][] visited) {
        if (isOutOfBoundary(row, col, grid.length, grid[0].length) || visited[row][col]) {
            return;
        }

        queue.offer(new int[] {row, col});
        visited[row][col] = true;

        int direction = grid[row][col] - 1;
        movePath(row + dir[direction][0], col + dir[direction][1], grid, queue, visited);
    }

    private boolean isOutOfBoundary(int row, int col, int m, int n) {
        return row < 0 || col < 0 || row == m || col == n;
    }
}
