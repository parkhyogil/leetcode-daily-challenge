class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        return quickSelect(0, n - 1, nums, n - k);
    }

    private int quickSelect(int l, int r, int[] nums, int k) {
        int pIdx = partition(l, r, nums);

        if (pIdx == k) {
            return nums[pIdx];
        } else if (pIdx < k) {
            return quickSelect(pIdx + 1, r, nums, k);
        } else {
            return quickSelect(l, pIdx - 1, nums, k);
        }
    }

    private int partition(int l, int r, int[] nums) {
        int m = (l + r) / 2;
        int pivot = nums[m];
        swap(m, r, nums);
        
        int pIdx = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(i, pIdx++, nums);
            }
        }
        swap(pIdx, r, nums);
        return pIdx;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
