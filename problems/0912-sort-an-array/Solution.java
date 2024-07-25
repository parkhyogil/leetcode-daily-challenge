class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums);

        return nums;
    }

    public void sort(int[] nums) {
        quickSort(0, nums.length - 1, nums);
    }

    private void quickSort(int l, int r, int[] nums) {
        if (l >= r) {
            return;
        }

        if (r - l + 1 <= 16) {
            insertionSort(l, r, nums);
            return;
        }
        
        int pivotPos = partition(l, r, nums);

        quickSort(l, pivotPos, nums);
        quickSort(pivotPos + 1, r, nums);
    }

    private int partition(int l, int r, int[] nums) {
        int pivotVal = nums[(l + r) / 2];

        int i = l; 
        int j = r;

        while (i <= j) {
            while (nums[i] < pivotVal) {
                i++;
            } 
            while (nums[j] > pivotVal) {
                j--;
            }

            if (i < j) {
                swap(i++, j--, nums);
            } else {
                i++;
            }
        }

        return j;
    }

    private void insertionSort(int l, int r, int[] nums) {
        for (int i = l + 1; i <= r; i++) {
            for (int j = i - 1; j >= l && nums[j] > nums[j + 1]; j--) {
                swap(j, j + 1, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
