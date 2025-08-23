class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int result = m * n;

        for (int i = 0; i < m - 1; i++) {
            int a = getArea(grid, 0, i, 0, n - 1);
            int b = getArea(grid, i + 1, m - 1, 0, n - 1);

            for (int j = 0; j < n - 1; j++) {
                result = Math.min(result, Math.min(
                        a + getArea(grid, i + 1, m - 1, 0, j) + getArea(grid, i + 1, m - 1, j + 1, n - 1),
                        b + getArea(grid, 0, i, 0, j) + getArea(grid, 0, i, j + 1, n - 1)
                ));
            }

            for (int j = i + 1; j < m - 1; j++) {
                result = Math.min(result, a + getArea(grid, i + 1, j, 0, n - 1) + getArea(grid, j + 1, m - 1, 0, n - 1));
            }
        }

        for (int j = 0; j < n - 1; j++) {
            int a = getArea(grid, 0, m - 1, 0, j);
            int b = getArea(grid, 0, m - 1, j + 1, n - 1);
            
            for (int i = 0; i < m - 1; i++) {
                result = Math.min(result, Math.min(
                        a + getArea(grid, 0, i, j + 1, n - 1) + getArea(grid, i + 1, m - 1, j + 1, n - 1),
                        b + getArea(grid, 0, i, 0, j) + getArea(grid, i + 1, m - 1, 0, j)
                ));
            }

            for (int i = j + 1; i < n - 1; i++) {
                result = Math.min(result, a + getArea(grid, 0, m - 1, j + 1, i) + getArea(grid, 0, m - 1, i + 1, n - 1));
            }
        }

        return result;
    }

    int getArea(int[][] grid, int r0, int r1, int c0, int c1) {
        while (r0 <= r1) {
            boolean containsOne = false;

            for (int i = c0; i <= c1; i++) {
                containsOne |= grid[r0][i] == 1;
            }

            if (containsOne) {
                break;
            }

            r0++;
        }

        while (r0 <= r1) {
            boolean containsOne = false;

            for (int i = c0; i <= c1; i++) {
                containsOne |= grid[r1][i] == 1;
            }

            if (containsOne) {
                break;
            }

            r1--;
        }

        while (c0 <= c1) {
            boolean containsOne = false;

            for (int i = r0; i <= r1; i++) {
                containsOne |= grid[i][c0] == 1;
            }

            if (containsOne) {
                break;
            }

            c0++;
        }

        while (c0 <= c1) {
            boolean containsOne = false;

            for (int i = r0; i <= r1; i++) {
                containsOne |= grid[i][c1] == 1;
            }

            if (containsOne) {
                break;
            }

            c1--;
        }

        return (r1 - r0 + 1) * (c1 - c0 + 1);
    }
}
