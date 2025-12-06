class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length, mod = (int) 1e9 + 7;

        Deque<Integer> asc = new ArrayDeque<>(), desc = new ArrayDeque<>();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        int j = -1;

        for (int i = 0; i < n; i++) {
            while (!asc.isEmpty() && nums[asc.getLast()] > nums[i]) {
                asc.removeLast();
            }
            while (!desc.isEmpty() && nums[desc.getLast()] < nums[i]) {
                desc.removeLast();
            }

            asc.addLast(i);
            desc.addLast(i);

            while (nums[desc.getFirst()] - nums[asc.getFirst()] > k) {
                if (desc.getFirst() < asc.getFirst()) {
                    j = Math.max(j, desc.removeFirst());
                } else {
                    j = Math.max(j, asc.removeFirst());
                }
            }

            dp[i + 1] = (dp[i] * 2 % mod - (j >= 0 ? dp[j] : 0) + mod) % mod; 
        }

        return (dp[n] - dp[n - 1] + mod) % mod;
    }
}
