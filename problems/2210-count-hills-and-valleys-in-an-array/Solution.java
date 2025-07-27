class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            int j = i;

            while (j + 1 < n && nums[j + 1] == nums[i]) {
                j++;
            }

            if (isHillOrValley(i, j, nums)) {
                result++;
            }

            i = j;
        }

        return result;
    }

    boolean isHillOrValley(int i, int j, int[] nums) {
        if (i - 1 < 0 || j + 1 == nums.length) {
            return false;
        }

        return nums[i - 1] > nums[i] ^ nums[j] > nums[j + 1];
    }
}
