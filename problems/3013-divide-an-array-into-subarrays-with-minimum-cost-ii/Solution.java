class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        boolean[] used = new boolean[n];

        int validCount = 0;
        long minSum = Long.MAX_VALUE;
        long sum = 0;

        for (int i = 1; i < n; i++) {
            int j = i - dist - 1;

            if (j > 0 && used[j]) {
                validCount--;
                sum -= nums[j];
                used[j] = false;
            }

            if (validCount < k - 1) {
                maxHeap.offer(i);
                sum += nums[i];
                used[i] = true;
                validCount++;
            } else {
                minHeap.offer(i);
            }

            while (!minHeap.isEmpty() && nums[maxHeap.peek()] > nums[minHeap.peek()]) {
                int x = maxHeap.poll();

                if (x < i - dist) {
                    continue;
                }

                int y = minHeap.poll();

                if (y < i - dist) {
                    maxHeap.offer(x);
                    continue;
                }

                maxHeap.offer(y);
                minHeap.offer(x);
                sum += nums[y] - nums[x];
                used[x] = false;
                used[y] = true;
            }

            if (validCount == k - 1) {
                minSum = Math.min(minSum, sum);
            }
        }

        return minSum + nums[0];
    }
}
