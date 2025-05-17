class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        
        int l = -1, r = n;

        for (int i = 0; i < r; i++) {
            if (nums[i] == 0) {
                swap(++l, i, nums);
            } else if (nums[i] == 2) {
                swap(--r, i--, nums);
            }
        }
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
