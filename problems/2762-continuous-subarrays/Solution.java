class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;

        Deque<Integer> increasingOrder = new ArrayDeque<>();
        Deque<Integer> decreasingOrder = new ArrayDeque<>();

        long result = 0L;

        for (int l = 0, r = 0; r < n; r++) {
            int num = nums[r];

            while (!increasingOrder.isEmpty() && nums[increasingOrder.getLast()] >= num) {
                increasingOrder.removeLast();
            }
            increasingOrder.addLast(r);

            while (!decreasingOrder.isEmpty() && nums[decreasingOrder.getLast()] <= num) {
                decreasingOrder.removeLast();
            }
            decreasingOrder.addLast(r);

            while (nums[decreasingOrder.getFirst()] - nums[increasingOrder.getFirst()] > 2) {
                if (decreasingOrder.getFirst() < increasingOrder.getFirst()) {
                    l = decreasingOrder.removeFirst() + 1;
                } else {
                    l = increasingOrder.removeFirst() + 1;
                }
            }

            result += r - l + 1;
        }

        return result;
    }
}
