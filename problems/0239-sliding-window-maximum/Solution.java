class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i + 1 - k >= 0) {
                res[i + 1 - k] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
