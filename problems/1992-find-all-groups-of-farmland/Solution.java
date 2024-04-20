class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    list.add(groupLand(i, j, land));
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    private int[] groupLand(int r, int c, int[][] land) {
        int r2 = r;
        while (r2 + 1 < land.length && land[r2 + 1][c] == 1) {
            r2++;
        }

        int c2 = c;
        while (c2 + 1 < land[0].length && land[r][c2 + 1] == 1) {
            c2++;
        }

        for (int i = r; i <= r2; i++) {
            for (int j = c; j <= c2; j++) {
                land[i][j] = 0;
            }
        }

        return new int[] {r, c, r2, c2};
    }
}