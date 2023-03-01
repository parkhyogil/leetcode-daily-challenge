class Solution {
    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }

    public int[] mergeSort(int[] nums) {
        mergeSortRec(nums, new int[nums.length], 0, nums.length - 1);
        return nums;
    }

    private void mergeSortRec(int[] nums, int[] tmp, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSortRec(nums, tmp, lo, mid);
        mergeSortRec(nums, tmp, mid + 1, hi);
        merge(nums, tmp, lo, mid, hi);
    }

    private void merge(int[] nums, int[] tmp, int lo, int mid, int hi) {
        for (int i = lo; i <= mid; i++) {
            tmp[i] = nums[i];
        }
        int i = lo;
        int j = mid + 1;

        int idx = lo;
        while (i <= mid && j <= hi) {
            if (tmp[i] <= nums[j]) {
                nums[idx++] = tmp[i++];
            } else {
                nums[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            nums[idx++] = tmp[i++];
        }
    }

    public int[] quickSort(int[] nums) {
        quickSortRec(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSortRec(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int[] p = partition(nums, lo, hi);
        quickSortRec(nums, lo, p[0]);
        quickSortRec(nums, p[1], hi);
    }

    private int[] partition(int[] nums, int lo, int hi) {
        int pivot = nums[(lo + hi) / 2];

        int i = lo;
        int j = hi;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i++, j--);
            } else {
                i++;
            }
        }
        return new int[] {j, j + 1};
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
