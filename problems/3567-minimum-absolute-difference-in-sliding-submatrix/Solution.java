class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> list = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        if (!set.contains(grid[r][c])) {
                            list.add(grid[r][c]);
                            set.add(grid[r][c]);
                        }
                    }
                }

                if (list.size() == 1) {
                    continue;                    
                }

                list.sort(Integer::compare);

                int diff = Integer.MAX_VALUE;

                for (int l = 0; l < list.size() - 1; l++) {
                    diff = Math.min(diff, list.get(l + 1) - list.get(l));
                }

                result[i][j] = diff;
            }
        }

        return result;
    }
}
