class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        long totalCost = 0;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i][1];
            totalCost += (long) (arr[i][0] - arr[0][0]) * arr[i][1];
        }

        long res = totalCost;
        for (int i = 1; i < n; i++) {
            int gap = arr[i][0] - arr[i - 1][0];
            totalCost += (2 * prefix[i] - prefix[n]) * gap;
            res = Math.min(res, totalCost);
        }
        return res;
    }
}            
