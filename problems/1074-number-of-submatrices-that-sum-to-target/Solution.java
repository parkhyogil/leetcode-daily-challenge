class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefixSum = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                prefixSum[r + 1][c + 1] = matrix[r][c] + prefixSum[r + 1][c] + prefixSum[r][c + 1] - prefixSum[r][c];
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int r1 = 1; r1 <= m; r1++) {
            for (int r2 = r1; r2 <= m; r2++) {
                map.clear();
                map.put(0, 1);
                for (int c = 1; c <= n; c++) {
                    int sum = prefixSum[r2][c] - prefixSum[r2][0] - prefixSum[r1 - 1][c] + prefixSum[r1 - 1][0];

                    res += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }
}
