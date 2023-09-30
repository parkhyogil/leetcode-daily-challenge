class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        int[] stack = new int[n];
        int idx = -1;

        int numK = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < numK) {
                return true;
            }

            while (idx >= 0 && nums[i] > stack[idx]) {
                numK = stack[idx--];
            }

            stack[++idx] = nums[i];
        }

        return false;
    }
}
