class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;

        int x = 51;
        int y = 51;

        for (int i = 1; i < n; i++) {
            if (nums[i] < x) {
                y = x;
                x = nums[i];
            } else if (nums[i] < y) {
                y = nums[i];
            }
        }

        return nums[0] + x + y;
    }
}
