class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int minIdx = findMinIdx(matrix[i]);
            int min = matrix[i][minIdx];

            if (isMaxInColumn(min, matrix, minIdx)) {
                res.add(min);
            }
        }

        return res;
    }

    private boolean isMaxInColumn(int val, int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] > val) {
                return false;
            }
        }
        return true;
    }

    private int findMinIdx(int[] row) {
        int res = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] < row[res]) {
                res = i;
            }
        }

        return res;
    }
}
