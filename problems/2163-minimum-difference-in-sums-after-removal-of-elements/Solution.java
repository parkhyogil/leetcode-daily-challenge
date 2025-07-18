class Solution {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m / 3;

        long[] prefix = new long[m];
        long[] suffix = new long[m];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        prefix[0] = nums[0];
        suffix[m - 1] = nums[m - 1];

        maxHeap.offer(nums[0]);
        minHeap.offer(nums[m - 1]);

        for (int i = 1; i < m; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            suffix[m - 1 - i] = suffix[m - i] + nums[m - 1 - i];

            maxHeap.offer(nums[i]);
            minHeap.offer(nums[m - 1 - i]);

            if (i >= n) {
                prefix[i] -= maxHeap.poll();
                suffix[m - 1 - i] -= minHeap.poll();
            }
        }

        long result = Long.MAX_VALUE;

        for (int i = n - 1; i < m - n; i++) {
            result = Math.min(result, prefix[i] - suffix[i + 1]);
        }

        return result;
    }
}
