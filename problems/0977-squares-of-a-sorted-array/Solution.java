class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        for (int i = n - 1, l = 0, r = n - 1; i >= 0; i--) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[i] = nums[l] * nums[l];
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                r--;
            }
        }

        return res;
    }
}
