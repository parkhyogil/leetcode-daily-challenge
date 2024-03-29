class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int r = m - 1;
        int c = 0;

        while (r >= 0 && c < n) {
            if (matrix[r][c] < target) {
                c++;
            } else if (matrix[r][c] > target) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }
}
