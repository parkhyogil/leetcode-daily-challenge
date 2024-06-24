class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;

        Queue<Integer> queue = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.poll();
            }

            nums[i] = nums[i] ^ (queue.size() % 2);

            if (nums[i] == 0) {
                if (i > n - k) {
                    return -1;
                }
                res++;
                nums[i] = 1;
                queue.offer(i);
            }
        }

        return res;
    }
}
