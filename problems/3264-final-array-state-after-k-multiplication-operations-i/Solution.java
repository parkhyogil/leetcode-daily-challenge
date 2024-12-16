class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> nums[a] == nums[b] ? Integer.compare(a, b) : Integer.compare(nums[a], nums[b]));
        
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(i);
        }

        for (int i = 0; i < k; i++) {
            int minIndex = priorityQueue.poll();

            nums[minIndex] *= multiplier;

            priorityQueue.offer(minIndex);
        }

        return nums;
    }
}
