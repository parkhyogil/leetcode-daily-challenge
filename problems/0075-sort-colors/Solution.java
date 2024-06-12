class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int zero = -1;
        int two = n;

        for (int i = 0; i < two; ) {
            int num = nums[i];

            if (num == 0) {
                swap(++zero, i++, nums);
            } else if (num == 1) {
                i++;
            } else {
                swap(--two, i, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
