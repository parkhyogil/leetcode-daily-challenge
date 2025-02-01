class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}
