class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        int[] indexStack = new int[n];
        int idx = -1;

        int maxWidth = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (idx == -1 || nums[i] > nums[indexStack[idx]]) {
                indexStack[++idx] = i;
            } else {
                maxWidth = Math.max(maxWidth, binarySearch(idx, indexStack, nums, nums[i]) - i);
            }
        }

        return maxWidth;
    }

    private int binarySearch(int high, int[] indexStack, int[] nums, int target) {
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[indexStack[mid]] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return indexStack[low];
    }
}
