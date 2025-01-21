class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] upper = new long[n + 1];
        long[] lower = new long[n + 1];

        for (int i = 0; i < n; i++) {
            upper[i + 1] = upper[i] + grid[0][i];
            lower[i + 1] = lower[i] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            result = Math.min(result, Math.max(getRangeSum(i + 1, n - 1, upper), getRangeSum(0, i - 1, lower)));
        }

        return result;
    }

    long getRangeSum(int left, int right, long[] arr) {
        return arr[right + 1] - arr[left];
    }
}
