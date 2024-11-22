class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maxEqualRows = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            if (row[0] == 1) {
                flip(row);
            }

            maxEqualRows = Math.max(maxEqualRows, map.merge(Arrays.hashCode(row), 1, Integer::sum));
        }

        return maxEqualRows;
    }

    void flip(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] ^= 1;
        }
    }
}
