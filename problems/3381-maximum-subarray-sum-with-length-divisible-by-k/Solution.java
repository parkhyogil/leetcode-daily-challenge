class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] arr = new long[n];
        Arrays.fill(arr, Long.MIN_VALUE);
        arr[0] = 0;

        long sum = 0;
        long result = Long.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int j = (i + 1) % k;

            if (i >= k - 1) {
                result = Math.max(result, sum - arr[j]);
            }

            if (arr[j] == Long.MIN_VALUE || arr[j] > sum) {
                arr[j] = sum;
            }
        }

        return result;
    }
}
