class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            boolean[] contains = new boolean[100001];
            int diff = 0;

            for (int j = i; j < n; j++) {
                if (!contains[nums[j]]) {
                    contains[nums[j]] = true;
                    diff += nums[j] % 2 == 0 ? 1 : -1;
                }

                if (diff == 0) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }
}
