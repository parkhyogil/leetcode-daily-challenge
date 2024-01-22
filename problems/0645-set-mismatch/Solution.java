class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i], i + 1};
            }
        }

        return null;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
