class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        long sum = 0;
        int numNeg = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];

                sum += Math.abs(v);
                if (v < 0) {
                    numNeg++;
                }
                min = Math.min(min, Math.abs(v));
            }
        }

        if (numNeg % 2 == 1) {
            sum -= min * 2;
        }

        return sum;
    }
}
