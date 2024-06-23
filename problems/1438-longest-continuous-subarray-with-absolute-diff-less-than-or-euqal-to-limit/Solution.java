class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));

        int res = 0;

        for (int l = 0, r = 0; r < n; r++) {
            while (!minHeap.isEmpty()) {
                if (minHeap.peek() < l) {
                    minHeap.poll();
                } else if (Math.abs(nums[minHeap.peek()] - nums[r]) > limit) {
                    l = Math.max(l, minHeap.poll() + 1);
                } else {
                    break;
                }
            }

            while (!maxHeap.isEmpty()) {
                if (maxHeap.peek() < l) {
                    maxHeap.poll();
                } else if (Math.abs(nums[maxHeap.peek()] - nums[r]) > limit) {
                    l = Math.max(l, maxHeap.poll() + 1);
                } else {
                    break;
                }
            }

            minHeap.offer(r);
            maxHeap.offer(r);

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
