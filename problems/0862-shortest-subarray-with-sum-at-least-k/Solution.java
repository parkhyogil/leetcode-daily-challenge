class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        int length = n + 1;
        int sum = 0;

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            sum += num;

            if (sum <= 0) {
                sum = 0;
                deque.clear();
                continue;
            }

            if (num > 0) {
                deque.offer(new int[] {i, num});

                while (!deque.isEmpty() && sum >= k) {
                    int[] first = deque.removeFirst();
                    length = Math.min(length, i - first[0] + 1);
                    sum -= first[1];
                }
            } else {
                int index = i;
                while (!deque.isEmpty() && num <= 0) {
                    int[] last = deque.removeLast();
                    index = last[0];
                    num += last[1];
                }

                deque.offer(new int[] {index, num});
            }
        }

        return length > n ? -1 : length;
    }
}
