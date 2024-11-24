class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long result = 0L;
        
        int numOfNegativeValues = 0;
        int minAbsValue = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    numOfNegativeValues++;
                }
                
                result += Math.abs(value);
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if (numOfNegativeValues % 2 == 1) {
            result -= minAbsValue * 2;
        }

        return result;
    }
}
