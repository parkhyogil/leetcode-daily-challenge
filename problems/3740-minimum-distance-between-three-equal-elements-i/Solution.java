class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[k]) {
                        result = Math.min(result, j - i + k - j + k - i);
                    }
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
