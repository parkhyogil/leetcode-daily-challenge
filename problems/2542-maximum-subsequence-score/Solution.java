class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        int[][] nums = new int[n][];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[] {nums1[i], nums2[i]};
        }

        Arrays.sort(nums, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i][0];
            minHeap.offer(nums[i][0]);
        }

        long res = sum * nums[k - 1][1];
        for (int i = k; i < n; i++) {
            if (nums[i][0] > minHeap.peek()) {
                sum += nums[i][0] - minHeap.poll();
                res = Math.max(res, sum * nums[i][1]);
                minHeap.offer(nums[i][0]);
            }
        }
        return res;
    }
}
