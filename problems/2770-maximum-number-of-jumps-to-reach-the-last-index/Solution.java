class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        int[] max = new int[n];
        Arrays.fill(max, -1);
        max[0] = 0;

        for (int i = 0; i < n; i++) {
            if (max[i] == -1) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    max[j] = Math.max(max[j], max[i] + 1);
                }
            }
        }

        return max[n - 1];
    }
}
