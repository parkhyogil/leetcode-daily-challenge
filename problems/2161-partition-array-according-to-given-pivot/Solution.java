class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int[] result = new int[n];

        int l = 0;
        int r = n - 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) {
                result[l++] = nums[i];
            }

            if (nums[j] > pivot) {
                result[r--] = nums[j];
            }
        }

        while (l <= r) {
            result[l++] = pivot;
        }

        return result;
    }
}
