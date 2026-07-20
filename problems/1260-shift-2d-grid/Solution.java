class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int l = m * n;
        k %= l;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>());

            for (int j = 0; j < n; j++) {
                int x = (i * n + j - k + l) % l;

                result.get(i).add(grid[x / n][x % n]);
            }
        }

        return result;
    }
}
