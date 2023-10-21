class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];

            while (!deque.isEmpty() && i - deque.getFirst() > k) {
                deque.removeFirst();
            }

            if (!deque.isEmpty()) {
                dp[i] += dp[deque.getFirst()];
            }

            while (!deque.isEmpty() && dp[i] > dp[deque.getLast()]) {
                deque.removeLast();
            }

            if (dp[i] > 0) {
                deque.addLast(i);
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
